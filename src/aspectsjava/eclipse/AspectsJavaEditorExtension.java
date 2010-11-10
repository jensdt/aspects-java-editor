package aspectsjava.eclipse;

import org.eclipse.swt.graphics.Image;
import java.io.IOException;

import jnome.editor.JavaEditorExtension;
import chameleon.core.element.Element;

public class AspectsJavaEditorExtension extends JavaEditorExtension {

	@Override
	public String getLabel(Element element) {
		try {
			return super.getLabel(element);
		} catch(NullPointerException exc) {
			return "";
		}
	}


	@Override
	protected void initializeRegistry() {
		super.initializeRegistry();
//		try {
//			register("component");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	
	}


  @Override
	public Image getIcon(Element element)  {
//  	Image result = null;
//  	if(element instanceof ComponentRelation) {
//		  result = imageRegistry().get("component");
//  	}
//  	return result;
	  return null;
	}


	@Override
	public String pluginID() {
		return Bootstrapper.PLUGIN_ID;
	}
}
