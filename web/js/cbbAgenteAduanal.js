var razonSocialStore = new Ext.data.JsonStore({		
	root: 'data',
	fields: ['bukrs','butxt'],
	autoLoad: true,
	proxy: new Ext.data.HttpProxy({ url: contextrootpath + '/provider/razonSocial.action', method: 'GET' })
});

var cuentasStore = new Ext.data.JsonStore({
	root: 'data2',
	fields: ['saknr',
	         'txt50',
	         {name: 'select', type:'bool'}
	         ],
	autoLoad: false,
//	proxy: new Ext.data.HttpProxy({ url: contextrootpath + '/provider/getCostCenter.action', method: 'GET' }),
	listeners: {
		exception : utilities.handleException
	}
});

var costCentersStore = new Ext.data.JsonStore({
	root: 'data1',
	fields: ['kostl',
	         'ltext',
	         {name: 'select', type:'bool'}
	         ],
	autoLoad: false,
//	proxy: new Ext.data.HttpProxy({ url: contextrootpath + '/provider/getCostCenter.action', method: 'GET' }),
	listeners: {
		exception : utilities.handleException
	}
});

var costCentersDS = new Ext.data.JsonStore({
	root: 'data1',
	fields: [{name :'lifnr', type:'string'},
	         {name :'bukrs', type:'string'},
	         {name :'itemcta', type:'string'},
	         {name :'ktopl', type:'string'},
	         {name :'hkont', type:'string'},
	         {name :'kokrs', type:'string'},
	         {name :'kostl', type:'string'} ],
	autoLoad: false
});

var areaStore = new Ext.data.JsonStore({
	root: 'data',
	fields: ['idDireccion','idGerencia','descDireccion','descGerencia'],
	autoLoad: false,
	proxy: new Ext.data.HttpProxy({ url: contextrootpath + '/provider/areas.action', method: 'GET' })
});

var responsableStore = new Ext.data.Store({
	recordType : areaStore.recordType
});

var cuentasRow = Ext.data.Record.create([
 	{name :'lifnr', type:'string'},
 	{name :'bukrs', type:'string'},
 	{name :'itemcta', type:'string'},
 	{name :'ktopl', type:'string'},
 	{name :'hkont', type:'string'},
 	{name :'kokrs', type:'string'},
 	{name :'kostl', type:'string'}
 ]);

 var cuentasStore = new Ext.data.JsonStore({
 	root: 'data',
 	fields: [{name :'lifnr', type:'string'},
 	         {name :'bukrs', type:'string'},
 	         {name :'itemcta', type:'string'},
 	         {name :'ktopl', type:'string'},
 	         {name :'hkont', type:'string'},
 	         {name :'kokrs', type:'string'},
 	         {name :'kostl', type:'string'}],
 	autoLoad: false,
 	proxy: new Ext.data.HttpProxy({ url: contextrootpath + '/provider/getCuentas.action', method: 'GET' }),
 	listeners: {
 		
 		load: function(t, r) {
 				var vlifnr = '',vbukrs='',vitemcta='',vktopl='',vhkont='';
 				costCentersStore.removeAll();
 		  		t.each(function(record) {	
 		  			if (vlifnr!=record.data.lifnr || vbukrs!=record.data.bukrs || vitemcta!=record.data.itemcta ||
 			  				vktopl!=record.data.ktopl || vhkont!=record.data.hkont) {
 			  				vlifnr   = record.data.lifnr;
 			  				vbukrs   = record.data.bukrs;
 			  				vitemcta = record.data.itemcta;
 			  				vktopl   = record.data.ktopl;
 			  				vhkont   = record.data.hkont;
 			  				var sr = new cuentasRow({
 			  					lifnr:record.data.lifnr,
 			  					bukrs:record.data.bukrs,
 			  					itemcta:record.data.itemcta,
 			  					ktopl:record.data.ktopl,
 			  					hkont:record.data.hkont,
 			  					kokrs:record.data.kokrs,
 			  					kostl:record.data.kostl
 			  				}); 
 			  				costCentersStore.insert(costCentersStore.getCount(), sr);
 			  			}
 		  			
 		  		});
 		},
 		 
 		exception : utilities.handleException
 	}
 });

 var costCentersStore = new Ext.data.JsonStore({
 	root: 'data1',
 	fields: [{name :'lifnr', type:'string'},
 	         {name :'bukrs', type:'string'},
 	         {name :'itemcta', type:'string'},
 	         {name :'ktopl', type:'string'},
 	         {name :'hkont', type:'string'},
 	         {name :'kokrs', type:'string'},
 	         {name :'kostl', type:'string'} ],
 	autoLoad: false
 });

 var cuentaMayorDS = new Ext.data.JsonStore({
 	id: 'cuentaMayorDS',
 	root: 'data',
     autoLoad: false,
     totalProperty: 'total',
     fields: [
 		{name :'lifnr', type:'string'},
 	         {name :'bukrs', type:'string'},
 	         {name :'itemcta', type:'string'},
 	         {name :'ktopl', type:'string'},
 	         {name :'hkont', type:'string'},
 	         {name :'kokrs', type:'string'},
 	         {name :'kostl', type:'string'}],
     sortInfo: { field: 'name', direction: "ASC" },
     proxy: new Ext.data.HttpProxy({ url: '/provider/dummy.action', method: 'POST' })
        
 });

 var cuentaMayorRow = Ext.data.Record.create([
 	{ name: 'hkont', type: 'string' },
 	{ name: 'kostl', type: 'string' },
 	{ name: 'amount', type: 'double' },
 	{ name: 'tax', type: 'double' },
 	{ name: 'project', type: 'string' }
 ]);
 
 function removeMetaData() {
		var row = Ext.getCmp('grdcuentaMayor').getSelectionModel().getSelected();
		cuentaMayorDS.remove(Ext.getCmp('grdcuentaMayor').getSelectionModel().getSelected());
//		Ext.MessageBox.show({
//			title: 'Confirm',
//			msg:"Are you sure want to delete column " +row.data.fieldname + " ?",
//			buttons: Ext.MessageBox.YESNO,
//			icon: Ext.MessageBox.INFO,
//			fn: function (btn){
//				if(btn=='yes'){
//					cuentaMayorDS.remove(Ext.getCmp('grdcuentaMayor').getSelectionModel().getSelected());
//					rowDeleted = true;
//				}
//		     }
//		});
	}


Ext.onReady(function(){
	
	Ext.QuickTips.init();
	
	Ext.form.Field.prototype.msgTarget = 'side';
	
	var lang;
	var params = Ext.urlDecode(window.location.search.substring(1));
	lang = params.language ? params.language : 'es';
	var bundle = new Ext.i18n.Bundle({bundle:'messages', path: contextrootpath + '/resources/language', lang: lang});
	bundle.onReady(function(){
		
		//********************************************** Components **************************************************/
		var cuentaMayorEditor = new Ext.ux.grid.RowEditor({
		    style: 'z-index: 8900',
		    autoCancel: false,
		    errorSummary: false,
		    saveText: bundle.getMsg('label.update'),
		    cancelText:bundle.getMsg('label.cancel'),
		    listeners: {
				beforeedit: function(roweditor, rowIndex) {
					criteriaRowIndex = rowIndex;
				}
			}
		});
		
		var tbarPnl1 = [{
			xtype: 'tbbutton',
			cls: 'x-btn-text-icon',
			icon: contextrootpath + '/resources/img/add.png',
			disabled: true,
			id:'btnCommand1',
			handler : function(){
				var cr = new cuentaMayorRow({
					hkont: '',			    	
					kostl: '',
					amount: '',
					tax:'',
					project:''
					
			    });
				cuentaMayorEditor.stopEditing();
				cuentaMayorDS.insert(cuentaMayorDS.getCount(), cr);
				grdcuentaMayor.getView().refresh();
				cuentaMayorEditor.startEditing(cuentaMayorDS.getCount() - 1);
			}
		}];
		var grdcuentaMayor = new Ext.grid.GridPanel({
			id: 'grdcuentaMayor',
			store: cuentaMayorDS,
			tbar :tbarPnl1,
			columns: [new Ext.grid.RowNumberer(),			
			          {header: bundle.getMsg('label.accountM'), width: 150, dataIndex: 'hkont', sortable : false, align: 'center',
						editor:{
							  xtype: 'combo',
				               name: 'hkont',
				               id: 'hkont',
				               width:140,
				               triggerAction: 'all',
				               selectOnFocus:true,
				               store:costCentersStore ,
				               allowBlank: true,
				               typeAhead: true,
				               mode: 'local',
				               forceSelection: true,
				               selectOnFocus:true,
				               valueField: 'hkont',
				               displayField: 'hkont',
						       listeners:{
						    	   select : function(c,rec,index){
									   var vhkont = '';
									   vhkont = rec.get('hkont');
									   costCentersDS.removeAll();
									  
										for (var i = 0; i < cuentasStore.getCount(); i++) {
											
											var record = cuentasStore.getAt(i);
											if (vhkont==record.data.hkont){
												var sr = new cuentasRow({
									  					lifnr:record.data.lifnr,
									  					bukrs:record.data.bukrs,
									  					itemcta:record.data.itemcta,
									  					ktopl:record.data.ktopl,
									  					hkont:record.data.hkont,
									  					kokrs:record.data.kokrs,
									  					kostl:record.data.kostl
									  				}); 
												    costCentersDS.insert(costCentersDS.getCount(), sr);
											}
											
									       
										}
									
								   }
							   }
				               
						}},
			          {header: bundle.getMsg('label.costCenter'), width: 80, dataIndex: 'kostl', sortable : false, align: 'center' ,
			        	  editor:{
							  xtype: 'combo',
				               name: 'kostl',
				               id: 'kostl',
				               width:140,
				               triggerAction: 'all',
				               selectOnFocus:true,
				               store:costCentersDS ,
				               allowBlank: true,
				               typeAhead: true,
				               mode: 'local',
				               forceSelection: true,
				               selectOnFocus:true,
				               valueField: 'kostl',
				               displayField: 'kostl'
						}}, //centro de costos
			          {header: bundle.getMsg('label.amount'), width: 80, dataIndex: 'amount', sortable : false, align: 'center',editor: {
			                xtype: 'numberfield',
			                allowBlank: false,
			                id:'amount'
			            }},
			          {header: bundle.getMsg('label.tax'), width: 80, dataIndex: 'tax', sortable : false, align: 'center',editor: {
			                xtype: 'combo',
			                id:'tax',
			    			name: 'tax',
			    			fieldLabel: bundle.getMsg('label.tax'),			
			    			store: new Ext.data.SimpleStore({
			    				idProperty: 'status',
			    				fields: ['IVA'],
			    				data:[
		    				      	  ['&nbsp;'],
			    				      ['16.00'],
			    				      ['11.00'],
			    				      ['0.00']
			    				      ]
			    			}),
			    			typeAhead: true,
			    			triggerAction: 'all',
			    			mode: 'local',
			    			forceSelection: true,
			    			allowBlank: true,			    			
			    			selectOnFocus: true,
			    			valueField: 'IVA',
			    			displayField: 'IVA',
			    			listeners: {
			    				select : function(comp,r,i) {
			    					if (comp.getValue() == "" || comp.getValue() == "&nbsp;") 
			    			               comp.setValue(null);
			    				}
			    			},
			    			width: 200
			            }},
			          {header: bundle.getMsg('label.project'), width: 80, dataIndex: 'project', sortable : false, align: 'center',editor: {
			                xtype: 'textfield',
			                allowBlank: true,
			                id:'project'
			          } },
			          {header: bundle.getMsg('label.delete'), width: 40, dataIndex: 'erase', sortable: false, align: 'center', renderer: function(v,meta) {
			        	  var but = '<div style="margin:0 auto; width: 20px;"><a href="#"><img src="' + contextrootpath  + '/resources/img/delete.png" onclick="removeMetaData();" title="Remove Meta Data" /></a></div>';
			        	  return but;
			          }}
			         
			          ],
			viewConfig: {forceFit: true},		
			border: false,			
			stripeRows: true,
			singleCheckSelect: true,
			widht : 600,
			height: 150,
			columnLines: true,
			autoScroll: true,			
			loadMask: true,
			selModel: new Ext.grid.RowSelectionModel({singleSelect: true}),
			plugins: cuentaMayorEditor
		});
		//********************************************** End Components **************************************************/
		var razonSocialField = new Ext.form.ComboBox({
			triggerAction: 'all',
			id: 'cmbRazonSocial',
			name: 'cmbRazonSocial',
			store : razonSocialStore,
			fieldLabel: bundle.getMsg('label.company'),
			valueField: 'bukrs',
			displayField: 'butxt',
			hiddenName: 'hdnRazonSocial',
			mode: 'local',
			allowBlank: false,
			width: 400,
			listeners: {
				select : function(c,rec,index){
					areaStore.load({
						params: {
							bukrs: rec.data.bukrs
						}
					});
					areaCmb.enable();
					areaCmb.clearValue();
					responsableCmb.disable();
					responsableCmb.clearValue();
					cuentasStore.load({
						params: {
							bukrs: rec.data.bukrs
						}
					});
					Ext.getCmp('btnCommand1').enable();
				}
			}
		});
		
		var areaCmb = new Ext.form.ComboBox({
			triggerAction: 'all',
			id: 'cmbAreas',
			name: 'cmbAreas',
			store : areaStore,
			fieldLabel: bundle.getMsg('label.area'),
			valueField: 'idDireccion',
			displayField: 'descDireccion',
			hiddenName: 'hdnArea',
			mode: 'local',
			disabled: true,
			allowBlank: false,
			width: 400
		});
		
		var responsableCmb = new Ext.form.ComboBox({
			triggerAction: 'all',
			id: 'cmbResponsable',
			name: 'cmbResponsable',
			store : responsableStore,
			disabled: true,
			fieldLabel: bundle.getMsg('label.responsible'),
			valueField: 'idGerencia',
			displayField: 'descGerencia',
			hiddenName: 'hdnResponsable',
			mode: 'local',
			allowBlank: false,
			width: 400
		});
		var d = new Date(new Date().getFullYear(), 0, 1);
		var fechaFactura = new Ext.form.DateField({
			fieldLabel: bundle.getMsg('label.invoicedate'),
			id: 'fechaInvoice',
			name: 'fechaInvoice',		
			allowBlank: false,
			format: 'Y-m-d',
			minValue: d,
			width: 130
		});
		
		var facturaField = new Ext.form.TextField({
			fieldLabel: bundle.getMsg('label.invoice'),
			id: 'invoice',
			name: 'invoice',
			maxLenght: 15,
			allowBlank: false,		
			width: 200
		});
		
		var conceptoField = new Ext.form.TextField({
			fieldLabel: bundle.getMsg('label.concept'),
			id: 'concepto',
			name: 'concepto',
			allowBlank: false,
			maxLenght: 25,
			width: 200
		});
		
		var subtotalField = new Ext.form.TextField({
			fieldLabel: 'Total',
			id: 'subtotal',
			name: 'subtotal',
			allowBlank: false,		
			width: 200
		});
		
		var ivaCmb = new Ext.form.ComboBox({
			id:'ivaCmb',
			name: 'ivaCmb',
			fieldLabel: bundle.getMsg('label.tax'),		
			store: new Ext.data.SimpleStore({
				idProperty: 'status',
				fields: ['IVA'],
				data:[
				      ['16.00'],
				      ['11.00'],
				      ['0.00']
				      ]
			}),
			typeAhead: true,
			triggerAction: 'all',
			mode: 'local',
			forceSelection: true,
			allowBlank: false,
			hiddenName: 'hdnIva',
			selectOnFocus: true,
			valueField: 'IVA',
			displayField: 'IVA',
			width: 200
		});
		
		var monedaCmb = new Ext.form.ComboBox({
			id:'monedaCmb',
			name: 'monedaCmb',
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
			hiddenName: 'hdnMoneda',
			valueField: 'Currency',
			displayField: 'Currency',
			width: 200
		});
		
		var retencionesField = new Ext.form.TextField({
			fieldLabel: bundle.getMsg('label.retentions'),
			id: 'retenciones',
			name: 'retenciones',
			allowBlank: false,		
			width: 200
		});
		
		var totalField = new Ext.form.TextField({
			fieldLabel: 'Total',
			id: 'total',
			name: 'total',
			allowBlank: false,		
			width: 200
		});	
		
		var uploadPDF = new Ext.ux.form.FileUploadField({
			fieldLabel: bundle.getMsg('label.pdffile'),
			name: 'file',			
			allowBlank: false,
	        width: 400
	    });
		
		var otherPDF = new Ext.ux.form.FileUploadField({
			fieldLabel: isOpdfMandatory ? bundle.getMsg('label.otherpdffilemandatoryco') : bundle.getMsg('label.otherpdffile'),
			name: 'file',
			id: 'other_pdf_doc',
			buttonText: bundle.getMsg('label.pickfile'),
			allowBlank: !isOpdfMandatory,
	        width: 400
	    });
		
		var accountField = new Ext.form.TextField({
			fieldLabel: bundle.getMsg('label.account'),
			id: 'account',
			name: 'account',
			allowBlank: true,
			readOnly: true,
			width: 200
		});
		
		var costCenterField = new Ext.form.TextField({
			fieldLabel: bundle.getMsg('label.costCenter'),
			id: 'costCenter',
			name: 'costCenter',
			allowBlank: true,
			readOnly: true,
			width: 200
		});
		
		var additionalFieldsBtn = new Ext.Button({
			text: bundle.getMsg('label.additionalFields'),
			id:'additionalFields',
			width: 180,
			handler : additionalFieldsWindow
		});
		
		var formCFDI = new Ext.form.FormPanel({
			title: bundle.getMsg('label.wopcbb'),
			id: 'cfdiForm',
			fileUpload: true,
			method: 'POST',
			bodyStyle: 'padding: 10px 10px 0 10px;',		
			frame: true,
			defaults: {
				msgTarget: 'side',
				anchor: '95%',
				labelWidth: 150
			},
			border: false,
			renderTo: 'formListaFactura',
			items:[{
				layout: 'form',
				border: false,
				items:[
				       razonSocialField,
				       areaCmb,
				       responsableCmb,
				       fechaFactura,
				       facturaField,
				       grdcuentaMayor,
//				       costCenterField,
				       conceptoField,
				       subtotalField,
				       ivaCmb,
//				       retencionesField,
//				       totalField,
				       monedaCmb,
				       uploadPDF,
				       otherPDF,{
				    	   xtype: 'hidden',
				    	   id:'accounting',
				    	   name: 'accounting'
				       }
				       ]
			}],
			buttonAlign: 'left',
			buttons:[{
				id: 'enviar',
				text: bundle.getMsg('label.send'),
				type: 'button',
				handler: enviarCFDI,
				style: {
					marginLeft : '15px'
				}
			}]
		});
		
		areaCmb.on('select',function(cmb,record,index){
			responsableCmb.enable();
			responsableCmb.reset();
			responsableStore.removeAll();
			responsableStore.add(record);
			responsableCmb.setValue(record.data.idGerencia);
		});
		
		function enviarCFDI(){
			var frm = Ext.getCmp('cfdiForm').getForm();
			if(frm.isValid()) {
				var data = new Array();
				cuentaMayorDS.each(function(r) {
					data.push(r.data);
				});
				Ext.getCmp('accounting').setValue(Ext.encode(data));
				Ext.Ajax.request({
					   url: contextrootpath + '/sessionStatus.action',
					   success: function(result,request) {
							if(result.responseText.indexOf("login")>=0) {
								Ext.MessageBox.alert(bundle.getMsg('label.sessionalerttitle'), bundle.getMsg('label.sessionalert'),relogin);					
							} else {
								frm.submit({
									url: contextrootpath + '/soc/addCBBAgentes.action',
									waitMsg: bundle.getMsg('label.savingcbb'),
									success: function(form,action){
										Ext.MessageBox.show({
											title: bundle.getMsg('label.success'),
											msg: action.result.msg,
											buttons: Ext.MessageBox.OK,
											icon: Ext.MessageBox.INFO
										});
										frm.reset();
										cuentaMayorDS.removeALl();
									},
									failure: function(form,action){
										switch (action.failureType) {
										  case Ext.form.Action.CLIENT_INVALID:
											 Ext.Msg.alert('Error', 'Valores inválidos');
											 frm.reset();
											 break;
										  case Ext.form.Action.CONNECT_FAILURE:
											 Ext.Msg.alert('Error', 'Falla de comunicación con el servidor');
											 frm.reset();
											 break;
										  case Ext.form.Action.SERVER_INVALID:
											 Ext.Msg.alert('Error', action.result.msg);
											 frm.reset();
											 break;
										  default:
											 Ext.Msg.alert('Error',action.result.msg);
										  	 frm.reset();
										  	 break;
										}
										cuentaMayorDS.removeALl();
									}
								});
							}
					   },
					   failure: utilities.expiredSession
				});	
				
			}else {		
				Ext.MessageBox.show({
					title: bundle.getMsg('label.alerttitle'),
					msg: bundle.getMsg('label.alert'),
					icon: Ext.MessageBox.INFO,
					buttons: Ext.MessageBox.OK
				});
			}
		}
	}); // end bundle
	
	function additionalFieldsWindow() {
		var razonSocialFieldS = new Ext.form.ComboBox({
			triggerAction: 'all',
			id: 'cmbRazonSocialS',
			name: 'cmbRazonSocialS',
			store : razonSocialStore,
			fieldLabel: bundle.getMsg('label.company'),
			valueField: 'bukrs',
			displayField: 'butxt',
			hiddenName: 'hdnRazonSocial',
			mode: 'local',
			allowBlank: false,
			width: 400
		});
		
		var gridAccounts = new Ext.grid.GridPanel({
			store: cuentasStore,
			columns: [new Ext.grid.RowNumberer(),
			          {header: bundle.getMsg('label.account'), width: 70, dataIndex: 'saknr', sortable : true, align: 'center'}, //cuenta
			          {header: bundle.getMsg('label.description'), width: 200, dataIndex: 'txt50', sortable : true, align: 'center'}, //descripcion
			          {header: bundle.getMsg('label.select'), width: 50, sortable : false, align: 'center', dataIndex: 'select', xtype: 'checkcolumn'}
			          ],
			viewConfig: {forceFit: true},		
			border: false,			
			stripeRows: true,
			singleCheckSelect: true,
			height: 100,
			columnLines: true,
			autoScroll: true,
			loadMask: true,
			selModel: new Ext.grid.RowSelectionModel({singleSelect: true})
		});
		
		var gridCostCenters = new Ext.grid.GridPanel({
			store: costCentersStore,
			columns: [new Ext.grid.RowNumberer(),			          
			          {header: bundle.getMsg('label.costCenter'), width: 80, dataIndex: 'kostl', sortable : true, align: 'center'}, //centro de costos
			          {header: bundle.getMsg('label.description'), width: 150, dataIndex: 'ltext', sortable : true, align: 'center'}, //descripcion          
			          {header: bundle.getMsg('label.select'), width: 50, sortable : false, align: 'center', 
			        	  dataIndex: 'select',			        	  			        	  
			        	  xtype: 'checkcolumn'}
			          ],
			viewConfig: {forceFit: true},		
			border: false,			
			stripeRows: true,
			singleCheckSelect: true,
			height: 100,
			columnLines: true,
			autoScroll: true,			
			loadMask: true,
			selModel: new Ext.grid.RowSelectionModel({singleSelect: true})
		});
		
		var formListaFactura = Ext.getCmp('listaFacturasForm') || new Ext.form.FormPanel({
//			title: bundle.getMsg('label.orderbuywithinvoice'),
			id: 'listaFacturasForm',
			method: 'POST',
			bodyStyle: 'padding-left: 20px;padding-right: 20px;padding-top: 20px;',		 
			layout: 'form',
			border: false,
			frame: true,
			renderTo: 'formListaFactura',
			items:[{
				layout: 'form',
				border: false,
				items:[
				       razonSocialFieldS				       
				       ]
			}],
			buttonAlign: 'left',
			buttons:[{
				id: 'filtrar',
				text: bundle.getMsg('label.filter'),
				type: 'button',
				handler: filtrarFacturas,
				style: {
					marginLeft : '15px'
				}
			}]
		});
		
		var winSelect = Ext.getCmp('winSelection') || new Ext.Window({
			id: 'winSelection',
			title: 'Selección de Documentos',
			frame: true,
			layout: 'form',
			closeAction: 'hide',
			width: 1050,
			modal: true,
			items: [formListaFactura,{
				layout: 'column',
				border: false,
				items:[{
					layout: 'form',
					border: false,
					columnWidth: .5,
					items:[gridAccounts]
				},{
					layout: 'form',
					border: false,
					columnWidth: .5,
					items:[gridCostCenters]
				}]
			}],
			buttons:[{
				text: 'Agregar',
				handler: function(){
					var account = null;
					var costCenter = null;
					gridAccounts.getStore().each(function(record){
						if(record.data.select){
							account = record;							
						}
					});
					gridCostCenters.getStore().each(function(record){
						if(record.data.select){
							costCenter = record;
						}
					});
					if( account == null || costCenter == null) {
						Ext.Msg.alert('Mensaje','Debe seleccionar una cuenta y un centro de costo');
					} else {
						Ext.getCmp('account').setValue(account.data.saknr);
						Ext.getCmp('costCenter').setValue(costCenter.data.kostl);
						winSelect.hide();
						cuentasStore.removeAll();
						costCentersStore.removeAll();
						formListaFactura.getForm().reset();
					}
				}
			}]
		});
		winSelect.show();
	}
	function filtrarFacturas() {
		var frm = Ext.getCmp('listaFacturasForm').getForm();	
		if(frm.isValid()){
			var values = frm.getFieldValues();
			console.log(values);
			Ext.Ajax.request({
				url: contextrootpath + '/provider/getCostCenter.action', 
				method: 'GET',
				params: {
					bukrs: values.hdnRazonSocial
				},
				success: function(result, request) {
					var results = Ext.decode(result.responseText);
					console.log(results);
					cuentasStore.loadData(results);
					costCentersStore.loadData(results);
				},
				failure: function(result, request) {
					var results = Ext.decode(result.responseText);					
					console.log(results);
					
				}
			});
//			cuentasStore.load({
//				params: {
//					bukrs: values.hdnRazonSocial
//				}
//			});
		} else {
			Ext.MessageBox.show({
				title: bundle.getMsg('label.message'),
				msg: bundle.getMsg('label.alert'),
				icon: Ext.MessageBox.INFO,
				buttons: Ext.MessageBox.OK
			});
		}
	}
});