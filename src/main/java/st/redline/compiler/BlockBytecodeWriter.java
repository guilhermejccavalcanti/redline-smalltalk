package st.redline.compiler;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

public class BlockBytecodeWriter extends ClassBytecodeWriter implements Opcodes {

	private static final String INVOKE_SIG = "(Lst/redline/PrimObject;Lst/redline/PrimContext;)Lst/redline/PrimObject;";

	final boolean methodBlock;

	BlockBytecodeWriter(String className, String packageName, boolean verbose, boolean methodBlock) {
		super(className, packageName, verbose);
		this.methodBlock = methodBlock;
	}

	BlockBytecodeWriter(String className, String packageName, boolean verbose, ClassWriter classWriter) {
		super(className, packageName, verbose, classWriter);
		this.methodBlock = false;
	}

	String superclass() {
		return methodBlock ? "st/redline/PrimObject" : "st/redline/PrimObjectBlock";
	}

	void addClassToImports() {
	}

	void deregisterPackage() {
	}

	void registerPackage() {
	}

	void invokeMessageSends() {
	}

	void openMessageSendsMethod() {
		openInvokeMethod();
	}

	void openInvokeMethod() {
		mv = cw.visitMethod(ACC_PROTECTED, "invoke", INVOKE_SIG, null, null);
		mv.visitCode();
		pushReceiver();
	}
}
