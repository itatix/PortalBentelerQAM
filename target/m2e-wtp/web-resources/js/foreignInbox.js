var listarDivision = false;
var listaTicketsStore = new Ext.data.JsonStore({
	root: 'data',
	fields: [
	         {name: 'ticket'},
	         {name: 'fecha'},
	         {name: 'lifnr'}	,
	         {name: 'select', type: 'bool'}
    ],
	autoLoad: false,
	proxy: new Ext.data.HttpProxy({ url: contextrootpath + '/freight/getTickets.action', method: 'GET' }),
	listeners: {			
		exception : utilities.handleException
	}
});

var referStore = new Ext.data.JsonStore({
	root: 'data',
	fields: [
			{name: 'trans'},
			{name: 'clave'},
			{name: 'texto'}
    ],
	autoLoad: false,
	proxy: new Ext.data.HttpProxy({ url: contextrootpath + '/freight/getRefer.action', method: 'GET' }),
	listeners: {			
		exception : utilities.handleException
	}
});

var tipoServicioStore = new Ext.data.JsonStore({
	root: 'data',
	fields: [
			{name: 'clave'},
			{name: 'texto'}
    ],
	autoLoad: false,
	proxy: new Ext.data.HttpProxy({ url: contextrootpath + '/freight/getServiceTypes.action', method: 'GET' }),
	listeners: {			
		exception : utilities.handleException
	}
});
var unidadTipoStore = new Ext.data.JsonStore({
	root: 'data',
	fields: [
			{name: 'clave'},
			{name: 'texto'}
    ],
	autoLoad: false,
	proxy: new Ext.data.HttpProxy({ url: contextrootpath + '/freight/getUnidadTipo.action', method: 'GET' }),
	listeners: {			
		exception : utilities.handleException
	}
})

var razonSocialStore = new Ext.data.JsonStore({		
	root: 'data',
	fields: ['bukrs','butxt'],
	autoLoad: true,
	proxy: new Ext.data.HttpProxy({ url: contextrootpath + '/provider/razonSocial.action', method: 'GET' })
});	

var divisionStore = new Ext.data.JsonStore({
	root: 'data',
	fields: ['segment','name'],
	autoLoad: false,
	proxy: new Ext.data.HttpProxy({ url: contextrootpath + '/provider/division.action', method: 'GET' })
});

Ext.onReady(function(){
//	getUnreadNotificationsNumber();
	var lang;
	var params = Ext.urlDecode(window.location.search.substring(1));
	lang = params.language ? params.language : 'es'; 
	Ext.QuickTips.init();
	Ext.form.Field.prototype.msgTarget = 'side';
	
	bundle = new Ext.i18n.Bundle({bundle:'messages', path: contextrootpath + '/resources/language', lang: lang});
	bundle.onReady(function(){		
		var razonSocialField = new Ext.form.ComboBox({
			triggerAction: 'all',
			id: 'cmbRazonSocial',
			name: 'cmbRazonSocial',
			hiddenName: 'bukrs',
			editable: false,
			store : razonSocialStore,
			fieldLabel: bundle.getMsg('label.company'),
			valueField: 'bukrs',
			displayField: 'butxt',
			mode: 'local',
			allowBlank: false,
			width: 250,
			listeners: {
				select : function(c,rec,index){
					if(listarDivision) {
						divisionStore.load({
							params: {
								bukrs: rec.data.bukrs
							}
						});
						division.enable();
						division.clearValue();
					}
					listaTicketsStore.load({
						params: {
							bukrs: rec.data.bukrs
						}
					});
				}
			}
		});
		
		var conceptField = new Ext.form.Field({
			fieldLabel: bundle.getMsg('label.concept'),
			id: 'concepto',
			name: 'concepto',
			allowBlank: false,
			width: 250
		});
		
		var fechaIni = new Ext.form.DateField({
			fieldLabel: bundle.getMsg('label.invoicedate'),
			id: 'fechaIni',
			name: 'fechaIni',		
			allowBlank: false,
			width: 130
		});
		
		var fechaFin = new Ext.form.DateField({
			fieldLabel: bundle.getMsg('label.invoicedateto'),		
			id: 'fechaFin',		
			name: 'fechaFin',		
			allowBlank: false,
			width: 130
		});
		
		var uploadXML = new Ext.ux.form.FileUploadField({
			fieldLabel: bundle.getMsg('label.xmlfile'),
			name: 'file',
			id: 'xml_doc',
			buttonText: bundle.getMsg('label.pickfile'),
			allowBlank: false,
			regex: /^.*\.(xml|XML)$/,
			regexText:'Solo archivos XML',
			width: 250,
	    });
		
		var uploadPDF = new Ext.ux.form.FileUploadField({
			fieldLabel: bundle.getMsg('label.pdffile'),
			name: 'file',
			id: 'pdf_doc',
			buttonText: bundle.getMsg('label.pickfile'),
			allowBlank: false,
			regex: /^.*\.(pdf|PDF)$/,
			regexText:'Solo archivos PDF',
			width: 250
	    });
		
		var otherPDF = new Ext.ux.form.FileUploadField({
			fieldLabel: bundle.getMsg('label.otherpdfzipfile'),
			name: 'file',
			id: 'other_pdf_doc',
			buttonText: bundle.getMsg('label.pickfile'),
			allowBlank: true,
			regex: /^.*\.(pdf|zip)$/i,
			regexText:'Solo archivos PDF/ZIP',
	        width: 250
	    });
		
		var tipoTransporteCmb = new Ext.form.ComboBox({
			id:'tipoTrans',
			name: 'cmbTipoTrans',
			hiddenName: 'tipoTrans',
			editable: false,
			fieldLabel: bundle.getMsg('label.freightType'),
			emptyText: bundle.getMsg('label.emptystatus'),
			store: new Ext.data.SimpleStore({
				idProperty: 'status',
				fields: ['IV_TRANSP','TRANSP'],
				data:[
				      [10,bundle.getMsg('cmb.air')],
				      [20,bundle.getMsg('cmb.land')],
				      [30,bundle.getMsg('cmb.overseas')]
				      ]
			}),
			typeAhead: true,
			triggerAction: 'all',
			mode: 'local',
			forceSelection: true,
			allowBlank: false,
			selectOnFocus: true,
			valueField: 'IV_TRANSP',
			displayField: 'TRANSP',
			width: 250,
			listeners: {
				'select': function(c,r,i) {
					referStore.removeAll();
					tipoServicioStore.removeAll();
					unidadTipoStore.removeAll();
					referStore.load({
						params:{
							type: r.data.IV_TRANSP
						}
					});
					tipoServicioStore.load({
						params: {
							type: r.data.IV_TRANSP
						}
					});
					unidadTipoStore.load({
						params: {
							type: r.data.IV_TRANSP
						}
					});
				}
			}
		});
		
		
		var currencyField = new Ext.form.ComboBox({
			id:'cmbCurrency',
			name: 'cmbCurrency',
			fieldLabel: bundle.getMsg('label.currency'),
			store: new Ext.data.SimpleStore({
				idProperty: 'status',
				fields: ['Currency'],
				data:[
				      ['MXN'],
				      ['USD'],
				      ['EUR'],
				      ['CAD'],
				      ['JPY']
				      ]
			}),
			typeAhead: true,
			triggerAction: 'all',
			mode: 'local',
			forceSelection: true,
			allowBlank: false,
			selectOnFocus: true,
			editable: false,
			hiddenName: 'currency',
			valueField: 'Currency',
			displayField: 'Currency',
			width: 200
		});
		
		var gridListaTickets = new Ext.grid.GridPanel({
			store: listaTicketsStore,
//			renderTo: 'gridListaFactura',
			columns: [
			          {header: 'Ticket', width: 100, dataIndex: 'ticket', sortable : true, align: 'center'},
			          {header: bundle.getMsg('label.date'), width: 100, dataIndex: 'fecha', sortable : true, align: 'center'},
			          {header: bundle.getMsg('label.select'), width: 50, sortable : false, align: 'center', dataIndex: 'select', xtype: 'checkcolumn'}
            ],
			viewConfig: {forceFit: true},		
			border: false,
			stripeRows: true,
			height: 300,
			columnLines: true,
			autoScroll: true,
			loadMask: true,
			selModel: new Ext.grid.RowSelectionModel({singleSelect: true})
		});
		
		var formFreight = new Ext.form.FormPanel({
			title: bundle.getMsg('menu.freight'),
			id: 'formFreight',
			fileUpload: true,
			method: 'POST',
			url: contextrootpath +'/saveFreight.action',
			bodyStyle: 'padding: 10px 10px 0 10px;',
			labelWidth: 100,
			frame: true,
			defaults: {
				msgTarget: 'side',
				anchor: '95%'
			},
			border: false,
			renderTo: 'formListaFactura',
			items:[{
				layout:'column',
				border: false,
				items:[{
					layout: 'form',
					columnWidth: '0.5',
					border: false,
					items:[
					       razonSocialField,
					       conceptField,
					       uploadPDF,
					       otherPDF,{
					    	   		xtype: 'numberfield',
					    	   		name: 'totalInvoice',
					    	   		fieldLabel: bundle.getMsg('lable.totalInvoice'),
					    	   		allowDecimals: true,
					       },
					       currencyField, {
					    	   		xtype: 'datefield',
					    	   		name: 'invoiceDate',
					    	   		fieldLabel: bundle.getMsg('label.invoicedate'),
					       }
					       
			        ]
				}, {
					layout: 'form',
					columnWidth: '0.5',
					border: false,
					items: [
					        gridListaTickets  
			        ]
				}]
			},{
				layout:'form',
				items: [
				     tipoTransporteCmb
		        ]
			},{
		        xtype:'fieldset',
		        collapsible: false,
		        labelAlign: 'top',
		        autoHeight:true,
		        hideBorders: true,
		        border: false,
		        layout: 'hbox',
		        defaultType: 'textfield',
		        items :[{
		                layout: 'form',
		                xtype: 'panel',
		                flex: 1,
		                items: [{
		                		xtype: 'textfield',
		                		id: 'origen',
		                		width: 180,
		            			name: 'origen',
		            			fieldLabel: bundle.getMsg('label.origin'),
		            			allowBlank: false
		                }]	
	            },{
		                anchor: '-5',
		                layout: 'form',
		                xtype: 'panel',
		                flex: 1,
		                items: [{
		                		xtype: 'textfield',
		                		width: 180,
		                		name: 'destino',
		                		fieldLabel: bundle.getMsg('label.destiny'),
		                }]
	            }]
			},{
		        // Fieldset in Column 1
		        xtype:'fieldset',
		        collapsible: false,
		        labelAlign: 'top',
		        autoHeight:true,
		        hideBorders: true,
		        border: false,
		        layout: 'hbox',
		        defaults: {
//		            anchor: '-20' // leave room for error icon
		        },
		        defaultType: 'textfield',
		        items :[{
		                layout: 'form',
		                xtype: 'panel',
		                flex: 1,
		                items: [{
		                		xtype: 'combo',
		                		id: 'referEmbarqueCmb',
		                		triggerAction: 'all',
		                		width: 180,
		            			name: 'referEmbarqueCmb',
		            			hiddenName: 'refer',
		            			editable: false,
		            			store : referStore,
		            			fieldLabel: bundle.getMsg('label.freightReference'),
		            			valueField: 'clave',
		            			displayField: 'texto',
		            			mode: 'local',
		            			allowBlank: false
		                }]	
		            }, {
		                anchor: '-5',
		                layout: 'form',
		                xtype: 'panel',
		                flex: 1,
		                items: [{
		                		xtype: 'textfield',
		                		width: 180,
		                		name: 'noRefer',
		                		fieldLabel: bundle.getMsg('label.referenceNumber'),
		                }]	
		            },{
		                anchor: '-5',
		                layout: 'form',
		                xtype: 'panel',
		                flex: 1,
		                items: [{
		                		xtype: 'datefield',
		                		name: 'fechaEmbarque',
		                		width: 180,
		                		fieldLabel: bundle.getMsg('label.shipmentDate'),
		                }]	
		            },{
		                anchor: '-5',
		                layout: 'form',
		                xtype: 'panel',
		                flex: 1,
		                items: [{
		                		xtype: 'combo',
		                		id: 'tipoServicioCmb',
		                		triggerAction: 'all',
		            			name: 'tipoServicioCmb',
		            			hiddenName: 'tipoSer',
		            			editable: false,
		            			width: 180,
		            			store : tipoServicioStore,
		            			fieldLabel: bundle.getMsg('label.serviceType'),
		            			valueField: 'clave',
		            			displayField: 'texto',
		            			mode: 'local',
		            			allowBlank: false
		                }]	
		            },{
		                anchor: '-5',
		                layout: 'form',
		                xtype: 'panel',
		                flex: 1,
		                items: [{
		                		xtype: 'combo',
		                		id: 'unidadTipoCmb',
		                		triggerAction: 'all',
		            			name: 'unidadTipoCmb',
		            			hiddenName: 'uniTipo',
		            			editable: false,
		            			width: 180,
		            			store : unidadTipoStore,
		            			fieldLabel: bundle.getMsg('label.unitType'),
		            			valueField: 'clave',
		            			displayField: 'texto',
		            			mode: 'local',
		            			allowBlank: false
		                }]	
		            }
		        ]
			},{
				layout:'form',
				labelWidth: 210,
				items: [{
					xtype: 'textfield',
					fieldLabel: bundle.getMsg('label.invoiceNumber'),
					allowBlank: false,
					name: 'noRemision',
					width: 350
				}]
			},{
				layout: 'form',
				items: [{
					xtype: 'textarea',
					fieldLabel: bundle.getMsg('label.observations'),
					name: 'observacion',
					width: 460
				},{
					xtype: 'hidden',
					id: 'tickets',
					name: 'tickets'
				},{
					xtype: 'hidden',
					id: 'tipoFac',
					name: 'tipoFac'
				}]
			}],
			buttonAlign: 'left',
			buttons:[{
				id: 'filtrar',
				text: bundle.getMsg('label.send'),
				type: 'button',
				handler: sendFreight,
				style: {
					marginLeft : '15px'
				}
			}]
		});
		
		
		
		function sendFreight() {
			var frm = Ext.getCmp('formFreight').getForm();	
			if(frm.isValid()){
				
				Ext.Ajax.request({
					   url: contextrootpath + '/sessionStatus.action',
					   success: function(result,request) {
							if(result.responseText.indexOf("login")>=0) {
								Ext.MessageBox.alert(bundle.getMsg('label.sessionalerttitle'), bundle.getMsg('label.sessionalert'),relogin);					
							} else {
								var tickets = [];
								listaTicketsStore.each(function(record){
									if(record.data.select)
										tickets.push(record.data);
								});
								console.log(Ext.encode(tickets));
								if(tickets.length > 0) {
									Ext.getCmp('tickets').setValue(Ext.encode(tickets));
								}
								Ext.getCmp('tipoFac').setValue("2");
								frm.submit({
									url: contextrootpath + '/freight/saveFreight.action',
									waitMsg: bundle.getMsg('label.saving'),
									success: function(form,action){
										Ext.MessageBox.show({
											title: 'Éxito',
											msg: action.result.msg,
											buttons: Ext.MessageBox.OK,
											icon: Ext.MessageBox.INFO
										});
										frm.reset();
										listaTicketsStore.removeAll();
										listaTicketsStore.reload();
									},
									failure: function(form,action){
										switch (action.failureType) {
										  case Ext.form.Action.CLIENT_INVALID:
											 Ext.Msg.alert('Error', 'Valores inválidos');
											 break;
										  case Ext.form.Action.CONNECT_FAILURE:
											 Ext.Msg.alert('Error', 'Falla de comunicación con el servidor');
											 break;
										  case Ext.form.Action.SERVER_INVALID:
											Ext.Msg.alert('Error', action.result.msg);
											break;
										  default:
											Ext.Msg.alert('Error',action.result.msg);
										  	break;
										}
									}
								});
							}
					   }
					});	

			} else {
				Ext.MessageBox.show({
					title: bundle.getMsg('label.alerttitle'),
					msg: bundle.getMsg('label.alert'),
					icon: Ext.MessageBox.INFO,
					buttons: Ext.MessageBox.OK
				});
			}
		}		
	}); // end bundle	
	
});

