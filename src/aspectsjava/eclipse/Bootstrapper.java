package aspectsjava.eclipse;

import java.io.File;
import java.io.IOException;

import jnome.output.JavaCodeWriter;
import aspectsjava.build.AspectsBuilder;
import aspectsjava.input.AspectsJavaModelFactory;
import aspectsjava.model.language.AspectsJava;
import chameleon.core.language.Language;
import chameleon.editor.connector.EclipseBootstrapper;
import chameleon.editor.connector.EclipseEditorExtension;
import chameleon.exception.ChameleonProgrammerException;
import chameleon.input.ModelFactory;
import chameleon.input.ParseException;
import chameleon.plugin.build.Builder;
import chameleon.plugin.output.Syntax;


public class Bootstrapper extends EclipseBootstrapper {
	
	public final static String PLUGIN_ID="be.chameleon.eclipse.aspects";
	
	public void registerFileExtensions() {
		addExtension("aspect");
	}
	
	public String getLanguageName() {
		return "AspectsJava";
	}

	public String getLanguageVersion() {
		return "1.0";
	}

	public String getVersion() {
		return "1.0";
	}

	public String getDescription() {
		return "Java with a simplified version of AoP";
	}
	
	public String getLicense() {
		return "";
	}

	public Syntax getCodeWriter() {
		return null;
	}

	public Language createLanguage() throws IOException, ParseException {
		AspectsJava result = new AspectsJava();
		ModelFactory factory = new AspectsJavaModelFactory(result);
		factory.setLanguage(result, ModelFactory.class);
		try {
			loadAPIFiles(".aspect", PLUGIN_ID, factory);
		} catch(ChameleonProgrammerException exc) {
			// Object and String may not be present yet.
		}
		result.setPlugin(EclipseEditorExtension.class, new AspectsJavaEditorExtension());
		result.setPlugin(Syntax.class, new JavaCodeWriter());
		return result;
	}
	
	public Builder createBuilder(Language source, File projectDirectory) {
//		RootNamespace clone = source.defaultNamespace().clone();
//		Java result = new Java();
//		result.cloneConnectorsFrom(source);
//		result.cloneProcessorsFrom(source);
//		result.setDefaultNamespace(clone);
//		result.setPlugin(Syntax.class, new JavaCodeWriter());
//		File outputDirectory = new File(projectDirectory.getAbsolutePath()+File.separator+"java");
//		return new AspectsBuilder((AspectsJava) source, result, outputDirectory);
		
		File outputDirectory = new File(projectDirectory.getAbsolutePath()+File.separator+"java");
		return new AspectsBuilder((AspectsJava) source, outputDirectory);

	}

}