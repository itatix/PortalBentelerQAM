var total;
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
	
	Ext.QuickTips.init();
	
	getUnreadNotificationsNumber();
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
			width: 400
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
			buttonText: bundle.getMsg('label.pickfile'),
			allowBlank: true,
			regex: /^.*\.(pdf|PDF)$/,
			regexText:'Solo archivos PDF',
	        width: 400
	    });
		
		var formCFDI;
			formCFDI = new Ext.form.FormPanel({
				title: bundle.getMsg('label.paymentComplement'),
				id: 'cbbForm',
				fileUpload: true,
				method: 'POST',
				bodyStyle: 'padding: 10px 10px 0 10px;',		
				frame: true,
				defaults: {
					msgTarget: 'side',
					anchor: '95%',
					labelWidth: 120,
				},
				border: false,
				renderTo: 'formListaFactura',
				items:[{
					layout: 'form',
					border: false,
					items:[
					       razonSocialField,
					       uploadXML,
					       uploadPDF,
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
		
		
		function enviarCFDI(){
			Ext.getCmp('cmbRazonSocial').enable();
			var frm = Ext.getCmp('cbbForm').getForm();
			if(frm.isValid()) {
				
				Ext.Ajax.request({
					   url: contextrootpath + '/sessionStatus.action',
					   success: function(result,request) {
							if(result.responseText.indexOf("login")>=0) {
								Ext.MessageBox.alert(bundle.getMsg('label.sessionalerttitle'), bundle.getMsg('label.sessionalert'),relogin);					
							} else {
								frm.submit({
									url: contextrootpath + '/oc/addPaymentSupplement.action',
									waitMsg: bundle.getMsg('label.savingcbb'),
									success: function(form,action){
										Ext.MessageBox.show({
											title: bundle.getMsg('label.success'),
											msg: action.result.msg,
											buttons: Ext.MessageBox.OK,
											icon: Ext.MessageBox.INFO
										});
										frm.reset();
									},
									failure: function(form,action){
										switch (action.failureType) {
										  case Ext.form.Action.CLIENT_INVALID:
											 Ext.MessageBox.show({
													title: 'Atención',
													msg: 'Valores inválidos',
													buttons: Ext.MessageBox.OK,
													icon: Ext.MessageBox.ERROR
											 });
											 frm.reset();
											 break;
										  case Ext.form.Action.CONNECT_FAILURE:
											 Ext.MessageBox.show({
													title: 'Atención',
													msg: 'Falla de comunicación con el servidor',
													buttons: Ext.MessageBox.OK,
													icon: Ext.MessageBox.ERROR
											 });
											 frm.reset();
											 
											 break;
										  case Ext.form.Action.SERVER_INVALID:
											 Ext.MessageBox.show({
													title: 'Atención',
													msg: action.result.msg,
													buttons: Ext.MessageBox.OK,
													icon: Ext.MessageBox.ERROR
											 });
											 frm.reset();
											 break;
										  default:
											 Ext.MessageBox.show({
													title: 'Atención',
													msg: action.result.msg,
													buttons: Ext.MessageBox.OK,
													icon: Ext.MessageBox.ERROR
											 });
											 frm.reset();
										  	 break;
										}
									}
								});
							}
					   		},
						   failure: utilities.expiredSession
				});	// end ajax request										
			}
		}
		
	});//end bundle
});