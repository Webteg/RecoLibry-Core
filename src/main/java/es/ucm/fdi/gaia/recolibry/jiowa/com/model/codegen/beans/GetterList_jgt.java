//
// AUTOMATICALLY GENERATED from template file GetterList.jgt
// 
// by the Jiowa Code Generation Framework (www.jiowa.de)
//

package com.model.codegen.beans;

import com.jiowa.template.variable.*;
import com.jiowa.template.bean.*;
import com.jiowa.template.bean.part.*;
import com.jiowa.template.variable.*;
import com.jiowa.template.variable.parser.*;
import com.jiowa.template.text.operator.*;
import java.util.*;

/**
 * AUTOMATICALLY GENERATED <br>
 *  
 * Template Bean: GetterList_jgt <br>
 * Generation Timestamp: Mon May 13 17:26:18 CEST 2019 <br>
 * JIOWA CodeGen Version: jiowa-codegen-2.1.6 
 * 
 * <p>
 * Generated by the JIOWA Code Generation Framework (<a href="http://www.jiowa.de">www.jiowa.de</a>) <br>
 * Written by <a href="http://www.mencl.de/">Robert Mencl</a> for <br>
 * JIOWA Business Solutions GmbH, Bettinastr. 30, D-60325 Frankfurt am Main, Germany.<br>
 * Download link: <a href="http://www.jiowa.de/download.html">www.jiowa.de/download.html</a> <br>
 * License: <a href="http://www.jiowa.de/license.html">www.jiowa.de/license.html</a>
 * 
 */
@SuppressWarnings("unused")
public class GetterList_jgt extends TemplateBean
{   
    /*------------------------------------------------------------------------*\
     * Fields & constants:                                                    *
    \*------------------------------------------------------------------------*/
    
    /**
     * The ID for this template bean. It is used for type mapping during automatic value propagation of subtemplates.
     */
    public static final java.lang.String ID = "GetterList.";            
    
    /*------------------------------------------------------------------------*\
     * Constructors:                                                          *
    \*------------------------------------------------------------------------*/

    public GetterList_jgt()
    {
        initialize();
    }

    /** 
     * Something similar like a copy constructor.
     * Actually it is a 'parent constructor'.
     * During evaluation, each time a variable or subtemplate has not been set the 
     * evaluator if has been set in the parent bean.
     * If so, it takes the values from the parent bean.
     * @param parent parent template bean for value propagation
     */    
    public GetterList_jgt(TemplateBean parent)
    {
        super(parent);  // 'parent constructor' similar to copy constructor. See explanation above!
        initialize();
    }
    
    /*------------------------------------------------------------------------*\
     * Static creation methods:                                               *
     * (often used while filling data into a template bean)                   *
    \*------------------------------------------------------------------------*/

    /**
     * Returns the id of this template bean (i.e. either template file name or inline subtemplate identifier.
     * @return the ID of this template bean as string value
     */
    @Override
    public java.lang.String id()
    {
        return ID; 
    }

    /*------------------------------------------------------------------------*\
     * Methods for template variables:                                        *
    \*------------------------------------------------------------------------*/

    /**
     * Returns the value of DataType.
     * @return value of DataType
     */
    public java.lang.String getDataType()
    {
        return variableValue("DataType"); 
    }
    
    /**
     * Sets the value of DataType.
     * @param value the value of DataType as string
     * @return the reference to the current template bean
     */
    public GetterList_jgt setDataType(java.lang.String value)
    {
        variableMap.put("DataType", value);
        return this;
    }
    
    /**
     * Returns the value of AttributeName.
     * @return value of AttributeName
     */
    public java.lang.String getAttributeName()
    {
        return variableValue("AttributeName"); 
    }
    
    /**
     * Sets the value of AttributeName.
     * @param value the value of AttributeName as string
     * @return the reference to the current template bean
     */
    public GetterList_jgt setAttributeName(java.lang.String value)
    {
        variableMap.put("AttributeName", value);
        return this;
    }

    /*------------------------------------------------------------------------*\
     * Classes & Methods for sub template structures:                         *
    \*------------------------------------------------------------------------*/

    /*------------------------------------------------------------------------*\
     * Creates the bean parts of this template bean that are used by the      *
     * super class for the toString() method.                                 *
    \*------------------------------------------------------------------------*/

    /** 
     * Initializer for variables and subtemplate structures
     * and for the data structures (i.e. bean parts) which prepare the bean data for the
     * toString() method.
     */
    protected void initialize()
    {
        // variables:
        variables.add("DataType");
        variables.add("AttributeName");        
        // subtemplates:        
        // bean parts for toString() method:
        partList.add(new TextPart("/**\n * Returns the value of type ",0));
        partList.add(new VariablePart("DataType","<<DataType>>",29));
        partList.add(new TextPart(" for attribute ",45));
        partList.add(new VariablePart("AttributeName","<<AttributeName>>",60));
        partList.add(new TextPart(".\n * @return value of ",81));
        partList.add(new VariablePart("AttributeName","<<AttributeName>>",20));
        partList.add(new TextPart("\n */\npublic List<",41));
        partList.add(new VariablePart("DataType","<<DataType>>",12));
        partList.add(new TextPart(" > get",28));
        partList.add(new VariablePart("AttributeName","<<+AttributeName>>",34,FirstToUpperCaseOperator.getInstance()));
        partList.add(new TextPart("()\n{\n    return this.",56));
        partList.add(new VariablePart("AttributeName","<<AttributeName>>",16));
        partList.add(new TextPart(";\n}\n\n",37));
    }
}


