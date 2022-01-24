var listaFacturaStore = new Ext.data.JsonStore({
	root: 'data',
	fields: ['saknr','txt50','kostl','ltext'],
	autoLoad: false,
	listeners: {
		exception: utilities.handleException
	},
	proxy: new Ext.data.HttpProxy({ url: contextrootpath + '/provider/getCostCenter.action', method: 'GET' })
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
//	Ext.MessageBox.show({
//		title: 'Confirm',
//		msg:"Are you sure want to delete column " +row.data.fieldname + " ?",
//		buttons: Ext.MessageBox.YESNO,
//		icon: Ext.MessageBox.INFO,
//		fn: function (btn){
//			if(btn=='yes'){
//				cuentaMayorDS.remove(Ext.getCmp('grdcuentaMayor').getSelectionModel().getSelected());
//				rowDeleted = true;
//			}
//	     }
//	});
}


Ext.onReady(function(){
	
	var razonSocialStore = new Ext.data.JsonStore({		
		root: 'data',
		fields: ['bukrs','butxt'],
		autoLoad: true,
		proxy: new Ext.data.HttpProxy({ url: contextrootpath + '/provider/razonSocial.action', method: 'GET' })
	});	
	
	
	
	Ext.QuickTips.init();
	
	var lang;
	var params = Ext.urlDecode(window.location.search.substring(1));
	lang = params.language ? params.language : 'es';
	bundle = new Ext.i18n.Bundle({bundle:'messages', path: contextrootpath + '/resources/language', lang: lang});
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
				console.log(cuentaMayorDS.getCount());
				var row = cuentaMayorDS.getAt(cuentaMayorDS.getCount() - 1);
				console.log(row);
				if(Ext.isEmpty(row) || !Ext.isEmpty(row.data.hkont)) {
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
				} else {
					cuentaMayorEditor.startEditing(cuentaMayorDS.getCount() - 1);
				}
				
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
			    			hiddenName: 'hdnIva',
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
		var areaStore = new Ext.data.JsonStore({
			root: 'data',
			fields: ['idDireccion','idGerencia','descDireccion','descGerencia'],
			autoLoad: false,
			proxy: new Ext.data.HttpProxy({ url: contextrootpath + '/provider/areas.action', method: 'GET' }),
			listeners: {
				exception : utilities.handleException
			}
		});
		
		var responsableStore = new Ext.data.Store({
			recordType : areaStore.recordType
		});
		
		Ext.form.Field.prototype.msgTarget = 'side';
		
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
					cuentaMayorDS.removeAll();
					cuentasStore.load({
						params: {
							bukrs: rec.data.bukrs
						},
						callback : function(r,options,success) {
							if(success) {
								Ext.getCmp('btnCommand1').enable();
							}
						}						
					});					
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
			disabled: true,
			hiddenName: 'hdnArea',
			mode: 'local',
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
		
		var facturaField = new Ext.form.TextField({
			fieldLabel: bundle.getMsg('label.invoice'),
			id: 'invoice',
			name: 'invoice',
			maxLength: 15,
			allowBlank: false,		
			width: 200
		});
		
		var conceptoField = new Ext.form.TextField({
			fieldLabel: bundle.getMsg('label.concept'),
			id: 'concept',
			maxLength: 25,
			name: 'concept',
			allowBlank: false,		
			width: 200
		});
		
		var uploadXML = new Ext.ux.form.FileUploadField({
			fieldLabel: bundle.getMsg('label.xmlfile'),
			name: 'file',
			buttonText: bundle.getMsg('label.pickfile'),
			allowBlank: false,
	        width: 400
	    });
		
		var uploadPDF = new Ext.ux.form.FileUploadField({
			fieldLabel: bundle.getMsg('label.pdffile'),
			name: 'file',
			buttonText: bundle.getMsg('label.pickfile'),
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
		
//		var additionalFieldsBtn = new Ext.Button({
//			text: bundle.getMsg('label.additionalFields'),
//			id:'additionalFields',
//			width: 180,
//			handler : additionalFieldsWindow
//		});
		
		var formCFDI = new Ext.form.FormPanel({
			title: bundle.getMsg('label.wopcfdi'),
			id: 'cfdiForm',
			fileUpload: true,
			method: 'POST',
			bodyStyle: 'padding: 10px 10px 0 10px;',		
			frame: true,
			defaults: {
				msgTarget: 'side',
				anchor: '95%',
				labelWidth: 150,
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
				       facturaField,
				       conceptoField,
				       grdcuentaMayor,
				       uploadXML,
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
		
	}); // end bundle
	
	
	
	
	function filtrarFacturas() {
		var frm = Ext.getCmp('listaFacturasForm').getForm();	
		if(frm.isValid()){
			var values = frm.getFieldValues();
			console.log(values);
			// Basic request
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

		} else {
			Ext.MessageBox.show({
				title: bundle.getMsg('label.message'),
				msg: bundle.getMsg('label.alert'),
				icon: Ext.MessageBox.INFO,
				buttons: Ext.MessageBox.OK
			});
		}
	}
	
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
							Ext.MessageBox.alert(bundle.getMsg('label.alerttitle'), bundle.getMsg('label.sessionalert'),relogin);					
						} else {
							frm.submit({
								url: contextrootpath + '/soc/addCFDIAgentes.action',
								waitMsg: bundle.getMsg('label.savingcfdi'),
								success: function(form,action){
									Ext.MessageBox.show({
										title: bundle.getMsg('label.success'),
										msg: action.result.msg,
										buttons: Ext.MessageBox.OK,
										icon: Ext.MessageBox.INFO
									});
									frm.reset();
									cuentaMayorDS.removeAll();
								},
								failure: function(form,action){
									switch (action.failureType) {
									  case Ext.form.Action.CLIENT_INVALID:
										 Ext.Msg.alert('Error', 'Valores inválidos');
										 frm.reset();
										 cuentaMayorDS.removeAll();
										 break;
									  case Ext.form.Action.CONNECT_FAILURE:
										 Ext.Msg.alert('Error', 'Falla de comunicación con el servidor');
										 frm.reset();
										 cuentaMayorDS.removeAll();
										 break;
									  case Ext.form.Action.SERVER_INVALID:
										Ext.Msg.alert('Error', action.result.msg);
										frm.reset();
										cuentaMayorDS.removeAll();
										break;
									  default:
										Ext.Msg.alert('Error',action.result.msg);
									  	frm.reset();
									  	cuentaMayorDS.removeAll();
									  	break;
								  }
								}
							});						
						}
				   },
				   failure: utilities.expiredSession
			});			
		}
	}
		
});



