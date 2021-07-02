package fr.inria.gforge.spoon;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.PrettyPrinter;

import fr.inria.gforge.spoon.transformation.IFoo;
import fr.inria.gforge.spoon.transformation.mutation.TestDriver;
import spoon.Launcher;
import spoon.SpoonModelBuilder;
import spoon.SpoonModelBuilder.InputType;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.visitor.filter.NamedElementFilter;
import spoon.reflect.visitor.filter.TypeFilter;
import spoon.support.JavaOutputProcessor;
import spoon.support.reflect.code.CtBinaryOperatorImpl;

public class Test1 {
	@SuppressWarnings("rawtypes")
	@Test
	public void testCase() {

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
				/*
				 * if (binaryOperator.getKind().equals(BinaryOperatorKind.GT)) {
				 * binaryOperator.setKind(BinaryOperatorKind.LT); } else if
				 * (binaryOperator.getKind().equals(BinaryOperatorKind.LT)) {
				 * binaryOperator.setKind(BinaryOperatorKind.GT); } else if
				 * (binaryOperator.getKind().equals(BinaryOperatorKind.GE)) {
				 * binaryOperator.setKind(BinaryOperatorKind.LE); } else if
				 * (binaryOperator.getKind().equals(BinaryOperatorKind.LE)) {
				 * binaryOperator.setKind(BinaryOperatorKind.GE); } else if
				 * (binaryOperator.getKind().equals(BinaryOperatorKind.EQ)) {
				 * binaryOperator.setKind(BinaryOperatorKind.NE); } else if
				 * (binaryOperator.getKind().equals(BinaryOperatorKind.NE)) {
				 * binaryOperator.setKind(BinaryOperatorKind.EQ); } else if
				 * (binaryOperator.getKind().equals(BinaryOperatorKind.AND)) {
				 * binaryOperator.setKind(BinaryOperatorKind.OR); } else if
				 * (binaryOperator.getKind().equals(BinaryOperatorKind.OR)) {
				 * binaryOperator.setKind(BinaryOperatorKind.AND); }
				 */
			}
			// ifStatement.setCondition(binaryOperator);
			System.out.println("changed expression is " + ifStatement.getCondition());
		}
		System.out.println("method is " + method.getElements(new TypeFilter<>(CtIf.class)));
		
		System.out.println(foo);
		
		TestDriver<TestClassIfStatement> testDriverForIFooObjects = new TestDriver<TestClassIfStatement>() {
			@Override
			public void test(TestClassIfStatement test) {
				assertEquals("a is greater than b", test.testMethodIfStatement(20, 10));
				assertEquals("a is less than b", test.testMethodIfStatement(10, 20));	
				System.out.println("test success");
			}
		};
		testDriverForIFooObjects.test(new TestClassIfStatement());
	}
}
