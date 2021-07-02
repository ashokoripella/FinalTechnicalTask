package fr.inria.gforge.spoon;

import static org.junit.Assert.assertEquals;

import java.util.List;

import fr.inria.gforge.spoon.transformation.mutation.TestDriver;
import spoon.Launcher;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.visitor.filter.NamedElementFilter;
import spoon.reflect.visitor.filter.TypeFilter;
import spoon.support.JavaOutputProcessor;

public class TranformOperatos {
	public static void main(String[] args) {
		
	

		Launcher l = new Launcher();
		l.setArgs(new String[] { "--source-classpath", "target/test-classes" });

		l.addInputResource("src/main/java/fr/inria/gforge/spoon");
		l.buildModel();
		l.setSourceOutputDirectory("src/main/java/output");
		l.setBinaryOutputDirectory("src/main/java/output");
		JavaOutputProcessor p = l.createOutputWriter();

		CtClass foo = l.getFactory().Package().getRootPackage()
				.getElements(new NamedElementFilter<>(CtClass.class, "TestClassIfStatement")).get(0);
		CtMethod<?> method = (CtMethod<?>) foo.getMethodsByName("testMethodIfStatement").get(0);

		List<CtIf> elements = method.getElements(new TypeFilter<>(CtIf.class));
		for (CtIf ifStatement : elements) {

			List<CtBinaryOperator> binaryElements = ifStatement.getCondition()
					.getElements(new TypeFilter<>(CtBinaryOperator.class));
			System.out.println("Bnary operators are " + binaryElements);
			// CtBinaryOperator binaryOperator = new CtBinaryOperatorImpl<>();
			Operators ralationalAndLogical = new Operators();
			for (CtBinaryOperator binaryOperator : binaryElements) {
				ralationalAndLogical.setrelationalCondition(binaryOperator);

			}
			System.out.println("changed expression is " + ifStatement.getCondition());
		}
		System.out.println("method is " + method.getElements(new TypeFilter<>(CtIf.class)));
		System.out.println(foo);
	}
}
