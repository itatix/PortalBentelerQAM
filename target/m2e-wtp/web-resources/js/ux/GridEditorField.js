/*!
 * @author Ashish Chaudhary
 */

Ext.ux.GridEditorField = Ext.extend(Ext.form.TriggerField, {  
    triggerClass: 'x-form-date-trigger',
    constructor: function(config){
    	Ext.ux.GridEditorField.superclass.constructor.call(this, config);
        Ext.apply(this, config);
        this.mimicing = false;
    },
    onTriggerClick : function(){
    	isTriggered = true;
        if(this.disabled){
            return;
        }
        if(this.menu == null){
        	if(this.isDateField){
    		   this.menu = new Ext.ux.DoubleDateMenu({
               	invokingParent :this
               });
        	}else if (this.isTimeField){
        		console.info("info:is time");
        		this.menu = new Ext.ux.DoubleTimeMenu({
                   	invokingParent :this
                   });
        	} 
        	else{
			   this.menu = new Ext.ux.DoubleNumberMenu({
	              	invokingParent :this
	           });
        	}
        	
        }
        this.onFocus();
        this.menu.show(this.el, "tl-bl?");
        this.menuEvents('on');
    },
    onMenuHide: function(){
        this.focus(false, 60);
        this.menu.show(this.el, "tl-bl?");
    },
    menuEvents: function(method){
        this.menu[method]('hide', this.onMenuHide, this);
        this.menu[method]('show', this.onFocus, this);
    },
    menuCollapse:function(){
    	this.menuEvents('un');
    	this.menu.hide();
    }
});

Ext.reg('uxGridEditorField', Ext.ux.GridEditorField);