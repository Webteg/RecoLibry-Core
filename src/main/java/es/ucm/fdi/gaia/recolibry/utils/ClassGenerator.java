package es.ucm.fdi.gaia.recolibry.utils;

import java.util.ArrayList;
import java.util.List;

import com.jiowa.codegen.config.JiowaCodeGenConfig;
import com.jiowa.codegen.generator.AbstractGenerator;
import com.model.codegen.beans.Attribute_jgt;
import com.model.codegen.beans.CaseComponent_jCOLIBRI_jgt;

public class ClassGenerator extends AbstractGenerator{
	
	private String className;
	private String packageName;
	private List<String[]> attributes; // Position 0 is name, position 1 is type
	
	public ClassGenerator(JiowaCodeGenConfig config) {
		super(config);
	}

	@Override
	public void generate() {
		// Create class
		CaseComponent_jCOLIBRI_jgt cbr_class = new CaseComponent_jCOLIBRI_jgt();
		cbr_class.setPackageName(packageName);
		cbr_class.setClassName(className);
		
		// Add attributes
		List<Attribute_jgt> attributes_jgt = new ArrayList<Attribute_jgt>();
		
		for(String[] a : attributes) {
			Attribute_jgt attr = cbr_class.foreachAttribute.append_Attribute_jgt().setDataType(a[1]).setAttributeName(a[0]);
			attributes_jgt.add(attr);
		}
		
		// Constructor arguments
		for(Attribute_jgt attr : attributes_jgt)
			cbr_class.foreachAttribute.append_Argument_jgt(attr);

        // Constructor arguments init
        for(Attribute_jgt attr : attributes_jgt)
            cbr_class.foreachAttribute.append_AttributeInit_jgt(attr);
		
		// Getters
		for(Attribute_jgt attr : attributes_jgt)
			cbr_class.foreachAttribute.append_Getter_jgt(attr);
		
		// Generate source file
		updateSourceFile("java/" + cbr_class.getPackageName().replace('.', '/') + "/" + cbr_class.getClassName() + ".java", cbr_class);                        

        System.out.println("Finish!!");
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public void setAttributes(List<String[]> attributes) {
		this.attributes = attributes;
	}
	
}