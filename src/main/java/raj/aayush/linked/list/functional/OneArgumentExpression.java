package raj.aayush.linked.list.functional;

/**
 */
@FunctionalInterface
public interface OneArgumentExpression<A,R> {
    R compute(A a);
}
