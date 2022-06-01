import java.util.stream.DoubleStream

class Calculator {
    fun add(vararg operands: Double): Double {
        return DoubleStream.of(*operands).sum()
    }
}