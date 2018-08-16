package raj.aayush.linked.list.functional;

/**
 */
@FunctionalInterface
public interface TwoArgumentExpression<A,B,R> {
    R compute(A lhs, B rhs);
}
