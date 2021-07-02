package fr.inria.gforge.spoon;

import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBinaryOperator;

public class Operators {
	public void setrelationalCondition(CtBinaryOperator binaryOperator) {
		if (binaryOperator.getKind().equals(BinaryOperatorKind.GT)) {
			binaryOperator.setKind(BinaryOperatorKind.LT);
		} else if (binaryOperator.getKind().equals(BinaryOperatorKind.LT)) {
			binaryOperator.setKind(BinaryOperatorKind.GT);
		} else if (binaryOperator.getKind().equals(BinaryOperatorKind.GE)) {
			binaryOperator.setKind(BinaryOperatorKind.LE);
		} else if (binaryOperator.getKind().equals(BinaryOperatorKind.LE)) {
			binaryOperator.setKind(BinaryOperatorKind.GE);
		} else if (binaryOperator.getKind().equals(BinaryOperatorKind.EQ)) {
			binaryOperator.setKind(BinaryOperatorKind.NE);
		} else if (binaryOperator.getKind().equals(BinaryOperatorKind.NE)) {
			binaryOperator.setKind(BinaryOperatorKind.EQ);
		} else if (binaryOperator.getKind().equals(BinaryOperatorKind.AND)) {
			binaryOperator.setKind(BinaryOperatorKind.OR);
		}else if (binaryOperator.getKind().equals(BinaryOperatorKind.OR)) {
			binaryOperator.setKind(BinaryOperatorKind.AND);
		}else if (binaryOperator.getKind().equals(BinaryOperatorKind.BITAND)) {
			binaryOperator.setKind(BinaryOperatorKind.AND);
		}else if (binaryOperator.getKind().equals(BinaryOperatorKind.BITOR)) {
			binaryOperator.setKind(BinaryOperatorKind.OR);
		}else if (binaryOperator.getKind().equals(BinaryOperatorKind.BITXOR)) {
			binaryOperator.setKind(BinaryOperatorKind.BITOR);
		}
	}
}
