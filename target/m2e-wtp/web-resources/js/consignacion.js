var total;
var periodRecord;
var razonSocialStore = new Ext.data.JsonStore({		
		root: 'data',
		fields: ['bukrs','butxt'],
		autoLoad: true,
		proxy: new Ext.data.HttpProxy({ url: contextrootpath + '/provider/razonSocial.action', method: 'GET' })
	});

var listaFacturaStore = new Ext.data.JsonStore({
	root: 'data',
	fields: [
		{name: 'zsem'},
		{name: 'low'},
		{name: 'high'},
		{name: 'matnr'},
		{name: 'mblnr'},
		{name: 'maktx'},
		{name: 'bstmg'},
		{name: 'bstme'},
		{name: 'netpr'},
		{name: 'netwr'},
		{name: 'waers'},
		{name: 'select', type:'bool'}
    ],
	autoLoad: false,
	proxy: new Ext.data.HttpProxy({ url: contextrootpath + '/consignacion/getDoctos.action', method: 'POST' }),
	listeners: {
		exception : utilities.handleException,
		load : function(t,r,o){
			t.each(function(record){
//				record.set('select',true); 
			});
		}
	}
});

var listaFacturaStoreD = new Ext.data.JsonStore({
	root: 'data',
	fields: [
	         {name: 'zsem'},
			 {name: 'low'},
			 {name: 'high'},
			 {name: 'matnr'},
			 {name: 'mblnr'},
			 {name: 'maktx'},
			 {name: 'bstmg'},
			 {name: 'bstme'},
			 {name: 'netpr'},
			 {name: 'netwr'},
			 {name: 'waers'}
    ],
	autoLoad: false,
	proxy: new Ext.data.HttpProxy({ url: contextrootpath + '/consignacion/getDoctos.action', method: 'POST' }),
	listeners: {
		exception : utilities.handleException
	}
});

Ext.onReady(function(){
	
	Ext.QuickTips.init();
	
	Ext.form.Field.prototype.msgTarget = 'side';		
	var lang;
	var params = Ext.urlDecode(window.location.search.substring(1));
	lang = params.language ? params.language : 'es';
	bundle = new Ext.i18n.Bundle({bundle:'messages', path: contextrootpath + '/resources/language', lang: lang});
	bundle.onReady(function(){
		
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
			width: 200			
		});		
		
		var uploadXML = new Ext.ux.form.FileUploadField({
			fieldLabel: bundle.getMsg('label.xmlfile'),
			name: 'file',
			id: 'xml_doc',
			buttonText: bundle.getMsg('label.pickfile'),
			allowBlank: false,
			regex: /^.*\.(xml|XML)$/,
			regexText:'Solo archivos XML',
	        width: 400
	    });
		
		var uploadPDF = new Ext.ux.form.FileUploadField({
			fieldLabel: bundle.getMsg('label.pdffile'),
			name: 'file',
			id: 'pdf_doc',
			buttonText: bundle.getMsg('label.pickfile'),
			allowBlank: false,
			regex: /^.*\.(pdf|PDF)$/,
			regexText:'Solo archivos PDF',
	        width: 400
	    });		
		
		var facturaField = new Ext.form.TextField({
			fieldLabel: bundle.getMsg('label.invoice'),
			id: 'factura',
			name: 'factura',
			allowBlank: true,		
			width: 200
		});		
		
		var fm = Ext.form;
		
		
		var btnSelectDoc = new Ext.Button({
			text: 'Seleccionar Periodos',
			handler: windowSelection
		});
		
		var gridListaFacD = new Ext.grid.GridPanel({
			store: listaFacturaStoreD,			
			columns: [new Ext.grid.RowNumberer(),
			          {header: 'Semana', width: 30, dataIndex: 'zsem', sortable : true, align: 'center'}, //
			          {header: 'De', width: 60, dataIndex: 'low', sortable : true, align: 'center'}, //
			          {header: 'Hasta', width: 60, dataIndex: 'high', sortable : true, align: 'center'}, //
					  {header: 'Nro Documento Material', width: 60, dataIndex: 'mblnr', sortable : true, align: 'center'}, //
			          {header: 'Código Material', width: 120, dataIndex: 'matnr', sortable : true, align: 'center'}, //
			          {header: 'Descrip. Material', width: 200, dataIndex:'maktx', sortable : true, align: 'center'}, //
			          {header: 'Cantidad', width: 50, dataIndex: 'bstmg', sortable : true, align: 'center'}, //
			          {header: 'UM', width: 30, dataIndex: 'bstme', sortable : true, align: 'center'}, //
			          {header: 'Subtotal', width: 120, dataIndex: 'netwr', sortable : true, align: 'center'}, //
			          {header: bundle.getMsg('label.currency'), width: 100, dataIndex: 'waers', sortable : true, align: 'center'} //Moneda
			          ],
			viewConfig: {forceFit: true},		
			border: false,
			bbar: [{xtype: 'tbtext', text: 'Total:'},'->',{tag: 'div', id: 'divTotalD', style: 'height:20px;width:100px;border:1px solid;margin-right:240px'}],
			stripeRows: true,
			height: 300,
			columnLines: true,
			autoScroll: true,
			loadMask: true,
			selModel: new Ext.grid.RowSelectionModel({singleSelect: true})
		});
		
		var formCFDI;		
		formCFDI = new Ext.form.FormPanel({
			title: bundle.getMsg('label.consignaciontitle'),
			id: 'cfdiForm',
			fileUpload: true,
			method: 'POST',
			bodyStyle: 'padding: 10px 10px 0 10px;',		
			frame: true,
			defaults: {
				msgTarget: 'side',
				anchor: '95%',
				labelWidth: 200,
			},
			border: false,
			renderTo: 'formListaFactura',
			items:[{
				layout: 'form',
				border: false,
				items:[
				       razonSocialField,
				       facturaField,
				       uploadXML,
				       uploadPDF,
				       btnSelectDoc,
				       gridListaFacD,{
				    	   xtype: 'hidden',
				    	   name: 'hdnFacturas',
				    	   id: 'hdnFacturas'
				       },{
				    	   xtype: 'hidden',
				    	   name: 'lowDate',
				    	   id: 'lowDate'
				       },{
				    	   xtype: 'hidden',
				    	   name: 'highDate',
				    	   id: 'highDate'
				       },{
				    	   xtype: 'hidden',
				    	   name: 'gjahr',
				    	   id: 'gjahr'
				       },{
				    	   xtype: 'hidden',
				    	   name: 'inicio',
				    	   id: 'inicio'
				       },{
				    	   xtype: 'hidden',
				    	   name: 'fin',
				    	   id: 'fin'
				       },{
				    	   xtype: 'hidden',
				    	   name: 'cerrado',
				    	   id: 'cerrado'
				       },{
				    	   xtype: 'hidden',
				    	   name: 'monat',
				    	   id: 'monat'
				       },{
				    	   xtype: 'hidden',
				    	   name: 'subto',
				    	   id: 'subto'
				       }]
					   
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

	}); //end bundle
	
	function windowSelection(){
		var razonSocialFieldS = new Ext.form.ComboBox({
			triggerAction: 'all',
			id: 'cmbRazonSocialS',
			name: 'cmbRazonSocialS',
			store : razonSocialStore,
			fieldLabel: bundle.getMsg('label.company'),
			valueField: 'bukrs',
			displayField: 'butxt',
			mode: 'local',
			allowBlank: false,
			width: 250			
		});
		
		var waers = Ext.getCmp('waers') || new Ext.form.TextField({
			id: 'currency',
			name: 'currency',
			fieldLabel: bundle.getMsg('label.currency'),
			allowBlank: true,
			maxLength: 3,
			width: 250
		});
		
		var periodStore = Ext.getCmp('periodStore') || new Ext.data.JsonStore({
			root: 'data',
			id: 'periodStore',
			fields: [{name:'inicio'},
			         {name:'fin'},
			         {name:'cerrado'},
			         {name:'gjahr'},
			         {name:'monat'},
			         {name:'select',type: 'bool'}
	        ],
			autoLoad: false,
			proxy: new Ext.data.HttpProxy({ url: contextrootpath + '/provider/getPeriods.action', method: 'GET' })
		});
		
		var btnSelectPeriods = new Ext.Button({
			text: 'Filtrar',
			handler: function() {
				// Testing data
//				var strData = "{\"total\":3,\"data\":[{\"inicio\":\"2016-01-01\",\"fin\":\"2016-06-06\",\"gjahr\":\"2016\",\"monat\":\"04\",\"cerrado\":\"\"},{\"inicio\":\"2016-01-01\",\"fin\":\"2016-06-06\",\"gjahr\":\"2016\",\"monat\":\"04\",\"cerrado\":\"\"},{\"inicio\":\"2016-01-01\",\"fin\":\"2016-06-06\",\"gjahr\":\"2016\",\"monat\":\"04\",\"cerrado\":\"\"}],\"msg\":\"Successful\",\"success\":true}";
//				var jsonStr = Ext.decode(strData);
//				console.log(jsonStr);
//				periodStore.loadData(jsonStr);
				periodStore.load({
					params: {
						bukrs: Ext.getCmp('cmbRazonSocialS').getValue()
					}
				});
			}
		});
		
		var periodGrid = new Ext.grid.GridPanel({
			id: 'periodGrid',
			store: periodStore,
			columns: [{header: "Seleccionar",width: 40,dataIndex: 'select', hideable:false,renderer:function(value,metaData,record) {
							var a = '<input type= "radio" name="radiogroup" style="margin-left:10px;"/>';
							return a;  
					  }},
			          {header: 'Año/Periodo', width: 40, dataIndex: 'gjahr', sortable : true, align: 'center'}, //
			          {header: 'Del', width: 60, dataIndex: 'inicio', sortable : true, align: 'center'}, //
			          {header: 'Al', width: 60, dataIndex: 'fin', sortable : true, align: 'center'}
			          ],
			viewConfig: {forceFit: true},		
			border: false,			
			stripeRows: true,
			listeners: {
				cellclick: function(thiz, rowIndex, columnIndex, e) {
					if(columnIndex == 0) { // select column
						this.store.each(function(record) {
							record.set('select',false);
						});
						var rec = thiz.getStore().getAt(rowIndex);
						rec.data['select'] = true ;
						periodRecord = rec;
					}
				}
			},
			height: 80,			
			autoScroll: true,
			loadMask: true,
			selModel: new Ext.grid.RowSelectionModel({singleSelect: true})	
		});

		var btnAgregarDoc = new Ext.Button({
			text: 'Agregar',
			handler: function(){
				var records = new Array();
				var gridData = Ext.getCmp('gridFactura');
				gridData.getStore().removeAll();
				listaFacturaStoreD.removeAll();
				listaFacturaStore.each(function(record){
					if(record.data.select){
						records.push(record);
					}
				});
				listaFacturaStoreD.add(records);
				var lastOptions = listaFacturaStore.lastOptions;
				var soc = Ext.getCmp('cmbRazonSocial');				
				if(lastOptions.params) {
					soc.setValue(lastOptions.params.bukrs);
					var index = soc.getStore().find('bukrs',lastOptions.params.bukrs);
					soc.fireEvent('select',soc,soc.getStore().getAt(index),index);														
				}
				soc.disable();				 
				
				var totalField = Ext.get('divTotalD');
				totalField.dom.innerHTML = Ext.util.Format.usMoney(total);
				winSelect.hide();
				listaFacturaStore.removeAll();				
				formListaFactura.getForm().reset();
				var totalFieldS = Ext.get('divTotal');
				totalFieldS.dom.innerHTML = Ext.util.Format.usMoney('0');
				
//				var lowDate = Ext.getCmp('lowDate');
//				var highDate = Ext.getCmp('highDate');
//				lowDate.setValue(fechaIni.getValue().format('Y-m-d'));
//				highDate.setValue(fechaFin.getValue().format('Y-m-d'));
			}
		});
		
		var gridListaFac = new Ext.grid.GridPanel({
			store: listaFacturaStore,
			 tbar: ['->',{
				 xtype: 'tbbutton',
				 text:'Seleccionar Todos',
				 handler: function(){
					 listaFacturaStore.each(function(record){
						 record.set('select',true); 
					 });
				 }
			 }],
			columns: [new Ext.grid.RowNumberer(),
			          {header: 'Semana', width: 40, dataIndex: 'zsem', sortable : true, align: 'center'}, //
			          {header: 'De', width: 60, dataIndex: 'low', sortable : true, align: 'center'}, //
			          {header: 'Hasta', width: 60, dataIndex: 'high', sortable : true, align: 'center'}, //
					  {header: 'Nro Doc. Material', width: 80, dataIndex: 'mblnr', sortable : true, align: 'center'}, //
			          {header: 'Código Material', width: 120, dataIndex: 'matnr', sortable : true, align: 'center'}, //
			          {header: 'Descrip. Material', width: 200, dataIndex:'maktx', sortable : true, align: 'center'}, //
			          {header: 'Cantidad', width: 50, dataIndex: 'bstmg', sortable : true, align: 'center'}, //
			          {header: 'UM', width: 30, dataIndex: 'bstme', sortable : true, align: 'center'}, //
			          {header: 'Subtotal', width: 120, dataIndex: 'netwr', sortable : true, align: 'center'}, //
			          {header: bundle.getMsg('label.currency'), width: 100, dataIndex: 'waers', sortable : true, align: 'center'},
					  // , //Moneda		          
			          {header: bundle.getMsg('label.select'), width: 80, sortable : false, align: 'center', dataIndex: 'select', xtype: 'checkcolumn'}
//			        	  renderer: function(value, metaData, record){
//			        	  if(value) {
//			        		  var total = 0;
//			        		  tmpStore = gridListaFac.getStore();
//			        		  tmpStore.each(function(record) {
//			                	if(record.data.select){
//			                		total = total + record.data.netwr;
//			                	}
//			        		  });
//				              var totalField = Ext.get('divTotal');
//				              totalField.dom(total);
//			        	  }
//			        	  return value;
//			          }
			          // }
			          ],
			viewConfig: {forceFit: true},		
			border: false,
			bbar: [{xtype: 'tbtext', text: 'Total:'},'->',{tag: 'div', id: 'divTotal', style: 'height:20px;width:100px;border:1px solid;margin-right:240px'}],
			stripeRows: true,
			height: 300,
			columnLines: true,
			autoScroll: true,
			loadMask: true,
			selModel: new Ext.grid.RowSelectionModel({singleSelect: true})			
		});
		
		var sociedad = Ext.getCmp('cmbRazonSocial');
//		var bukrsField = Ext.getCmp('cmbDivision');
//		if(sociedad.getValue()) {
////			razonSocialFieldS.setValue(sociedad.getValue());
////			var index = sociedad.getStore().find('bukrs',sociedad.getValue());
////			razonSocialFieldS.fireEvent('select',razonSocialFieldS,razonSocialFieldS.getStore().getAt(index),index);
//			
//		}				
		
		gridListaFac.getStore().on('update', function(t,r,o) {
			total = 0;
			
			t.each(function(record){
				if(record.data.select){
					total = total + (record.data.netwr * 1);
				}
			});
			var totalField = Ext.get('divTotal');
			totalField.dom.innerHTML = Ext.util.Format.usMoney(total);
			
		});
		
		var sociedad = Ext.getCmp('cmbRazonSocial');		
		if(sociedad.getValue()) {
			razonSocialFieldS.setValue(sociedad.getValue());
			var index = sociedad.getStore().find('bukrs',sociedad.getValue());
			razonSocialFieldS.fireEvent('select',razonSocialFieldS,razonSocialFieldS.getStore().getAt(index),index);			
		}
		
		var cm = new Ext.grid.ColumnModel({
			defaults: {
				sortable: false,
				menuDisabled: true
			},
			columns:[{
				id: 'factura',
				header: 'Nro Documento',
				dataIndex: 'Facs',
				editor: new Ext.form.TextField({
					allowBlank: false,
					maxLength : 10,
					// minLength: 10,
					maskRe: /[0-9.]/
					// autoCreate: {
						// tag: 'input',
						// type: 'text',
						
					// }
				})
			},{
				xtype: 'actioncolumn',
				width: 30,
				menuDisabled: true,
				items: [{
					icon: contextrootpath + "/resources/img/delete.png",
					handler: function(grid, rowIndex, colIndex){
						storeFacTmp.removeAt(rowIndex);
					}
				}]
			}]
		});
		
		var storeFacTmp =  new Ext.data.SimpleStore({
			idProperty: 'status',
			fields: ['Facs','eliminar'],
			data:[],
			listeners: {
				// add: function(t,records,index, eOpts) {
					// for(var i in records) {
						// var idx = t.findExact('Facs',records[i].get('Facs'));
						// if(idx != -1 && idx < index) 
							// t.remove(records[i]);
					// }	
				// }
			}
		});
		
		var gridFactura = new Ext.grid.EditorGridPanel({
			store: storeFacTmp,
			title: 'Nro Documento Material',
			id: 'gridFactura',
			cm: cm,
			width: 300,
			height: 200,
			autoExpandColumn: 'factura',
			clicksToEdit: 1,
			tbar: [{
				text: 'Agregar Documento',
				handler: function(){
					var fac = gridFactura.getStore().recordType;
					var f = new fac({
						Facs: '',
						eliminar : ''
					});
					gridFactura.stopEditing();
					storeFacTmp.insert(0,f);
					gridFactura.startEditing(0,0);
				}
			}],
			listeners: {
				afteredit: function(e) {
					console.log(e);
					var idx = e.grid.getStore().findExact('Facs',e.value, 1);
					if(idx != -1 && idx != e.row) {
						e.grid.getStore().removeAt(e.row);
					}
				}
			}
		});
		
		var formListaFactura = Ext.getCmp('listaFacturasForm') || new Ext.form.FormPanel({
			title: bundle.getMsg('label.orderbuywithinvoice'),
			id: 'listaFacturasForm',
			method: 'POST',
			bodyStyle: 'padding-left: 20px;padding-right: 20px;padding-top: 20px;',		 
			layout: 'form',
			border: false,
			frame: true,
			renderTo: 'formListaFactura',
			items:[{
				layout: 'column',
				border: false,
				items:[{
						layout: 'form',
						columnWidth: 1,
						border: false,
						items:[
//							   razonSocialFieldS,
							   {
								   layout: 'hbox',
								   border: false,
								   defaults:{margins:'0 10 0 0'},
								   items: [{			    		   
									   layout: 'form',
									   border: false,
									   items:[razonSocialFieldS]
								   },{			    		   
									   layout: 'form',
									   border: true,
									   labelWidth: 25,
									   items:[btnSelectPeriods]
								   }, {
									   layout: 'form',
									   border: true,
									   items:[waers]
								   }]
							   }
							   ]
					},{
						layout: 'form',
						border: false,
						columnWidth: .5,
						items:[periodGrid]
					}]
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
			items: [formListaFactura,gridListaFac,btnAgregarDoc]
		});
		winSelect.show();
	}
	
	function filtrarFacturas() {
		var frm = Ext.getCmp('listaFacturasForm').getForm();	
		if(frm.isValid()){
			var values = frm.getFieldValues();
			console.log(values);
			listaFacturaStore.removeAll();
			var gridData = Ext.getCmp('periodGrid');			
			var storeData = gridData.getStore();			
			if(undefined == periodRecord){
				storeData.each(function(record){
					console.log(record);
					if(record.data.select){
						periodRecord = record;						
					}
				});
			}									
			listaFacturaStore.load({
				params:{
					bukrs: values.cmbRazonSocialS,
					inicio: periodRecord.data.inicio,
					fin: periodRecord.data.fin,
					cerrado: periodRecord.data.cerrado,
					gjahr: periodRecord.data.gjahr,
					monat: periodRecord.data.monat,
					werks: periodRecord.data.werks,
					waers: values.currency
				}//,
//				callback: function(r,o,s) {
//					if(s) {
//						listaFacturaStore.each(function(record){
//							record.set('select',true); 
//						});
//					}
//				}
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
		Ext.getCmp('enviar').disable();
		Ext.getCmp('cmbRazonSocial').enable();		
		var frm = Ext.getCmp('cfdiForm').getForm();
		if(frm.isValid()) {
			
			var data = new Array();
						
			listaFacturaStoreD.each(function(r){
				data.push(r.data);
			});
			
			Ext.getCmp('hdnFacturas').setValue(Ext.encode(data));	
			
			Ext.getCmp('inicio').setValue(periodRecord.data.inicio);
			Ext.getCmp('fin').setValue(periodRecord.data.fin);
			Ext.getCmp('cerrado').setValue(periodRecord.data.cerrado);
			Ext.getCmp('highDate').setValue(periodRecord.data.highDate);
			Ext.getCmp('lowDate').setValue(periodRecord.data.lowDate);
			Ext.getCmp('monat').setValue(periodRecord.data.monat);
			Ext.getCmp('gjahr').setValue(periodRecord.data.gjahr);
			
			Ext.Ajax.request({
				   url: contextrootpath + '/sessionStatus.action',
				   success: function(result,request) {
						if(result.responseText.indexOf("login")>=0) {
							Ext.MessageBox.alert(bundle.getMsg('label.sessionalerttitle'), bundle.getMsg('label.sessionalert'),relogin);					
						} else {
							frm.submit({
								url: contextrootpath + '/consignacion/addConsignacion.action',
								waitMsg: bundle.getMsg('label.savingcfdi'),
								success: function(form,action){
									Ext.MessageBox.show({
										title: 'Éxito',
										msg: bundle.getMsg('label.cfdisaved') + action.result.msg,
										buttons: Ext.MessageBox.OK,
										icon: Ext.MessageBox.INFO
									});
									frm.reset();									
									listaFacturaStoreD.removeAll();
									var totalField = Ext.get('divTotalD');
									totalField.dom.innerHTML = Ext.util.Format.usMoney('0');
									Ext.getCmp('enviar').enable();
								},
								failure: function(form,action){
									switch (action.failureType) {
									  case Ext.form.Action.CLIENT_INVALID:
										 Ext.Msg.alert('Error', 'Valores inválidos');
										 frm.reset();										 
										 listaFacturaStoreD.removeAll();
										 var totalField = Ext.get('divTotalD');
										 totalField.dom.innerHTML = Ext.util.Format.usMoney('0');
										 break;
									  case Ext.form.Action.CONNECT_FAILURE:
										 Ext.Msg.alert('Error', 'Falla de comunicación con el servidor');
										 frm.reset();										 
										 listaFacturaStoreD.removeAll();
										 var totalField = Ext.get('divTotalD');
										 totalField.dom.innerHTML = Ext.util.Format.usMoney('0');
										 break;
									  case Ext.form.Action.SERVER_INVALID:
										Ext.Msg.alert('Error', action.result.msg);
										frm.reset();										
										listaFacturaStoreD.removeAll();
										var totalField = Ext.get('divTotalD');
										 totalField.dom.innerHTML = Ext.util.Format.usMoney('0');
										break;
									  default:
										Ext.Msg.alert('Error',action.result.msg);
									  	frm.reset();									  	
									  	listaFacturaStoreD.removeAll();
									  	var totalField = Ext.get('divTotalD');
										totalField.dom.innerHTML = Ext.util.Format.usMoney('0');
									  	break;
									}
									Ext.getCmp('enviar').enable();
								}
							});
						}
				   }
				});						
		}
	}	
	
});

