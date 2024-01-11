package calculatorsmp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperationsTest {

    private String formula;

    public OperationsTest() {
    }

    /**
     * Genera una fórmula aleatoria antes de cada test
     */
    @BeforeEach
    @DisplayName("Generar fórmula")
    public void setUp() {
        formula = Operations.MakeFormula();
        System.out.println("Formula generada: " + formula);
        notNull();
    }

    // Test del método MakeFormula

    @Test
    @DisplayName("Estructura correcta de la fórmula")
    public void testEstructuraCorrecta() {
        assertTrue(formula.matches("(\\d+[-+*/])+\\d+"));
        System.out.println("Formato correcto: " + formula);
    }

    @Test
    @DisplayName("No empieza con operador")
    public void testNoEmpiezaConOperador() {
        assertTrue(formula.matches("^[^*+/\\\\-].*"));
    }

    @Test
    @DisplayName("Devuelve al menos dos números para las operaciones")
    public void testAlMenosDosNumerosParaOperar() {
        assertTrue(formula.matches(".*\\d+.*\\d+.*"));
    }

    @Test
    public void notNull() {
        assertNotNull(formula);
    }

    @Test
    public void notEmpty() {
        assertFalse(formula.isEmpty());
    }

    /**
     * Pone en null a la fórmula después de cada test
     */
    @AfterEach
    @DisplayName("Pone en null a la formula")
    public void tearDown() {
        formula = null;
    }

    // Test del método Solve

    @Test
    @DisplayName("Valor esperado")
    public void testValorEsperado() {
        String formula = "42+54*12/3";
        String expResult = formula + "=258";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
        System.out.println("Valor esperado: " + result);
        System.out.println("Valor obtenido: " + expResult);
    }

    @Test
    @DisplayName("Arroja excepción cuando la fórmula está vacía")
    public void testFormulaVacia() {
        String formula = "";
        assertThrows(java.util.EmptyStackException.class, () -> Operations.Solve(formula));
    }

    @Test
    @DisplayName("Arroja excepción en una división para cero")
    public void testDivisionParaCero() {
        String formula = "10/0";
        assertThrows(ArithmeticException.class, () -> Operations.Solve(formula));
    }

    @Test
    @DisplayName("Resuelve con números negativos")
    public void testResuelveConValoresNegativos() {
        String formula = "-2+2";
        String expected = formula + "=0";
        String result = Operations.Solve(formula);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Arroja null pointer exception cuando la fórmula es null")
    public void testFormulaNula() {
        String formula = null;
        assertThrows(NullPointerException.class, () -> Operations.Solve(formula));
    }
}
