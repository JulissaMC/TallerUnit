# Taller JUnit Grupo 8

**NOTA:** Tuvimos inconvenientes para ejecutar en NetBeans, las pruebas fueron ejecutadas en Visual Studio Code.

## Integrantes

- LEÓN MARQUEZ OLIVIER RAPHAEL
- MOLINA CORTEZ JANETH JULISSA
- NIEVES REYES GEOVANNY ALEXANDER

## Casos de Prueba Identificados

| Identificador | Propósito | Entradas | Salidas esperadas |
| ------------- | --------- | -------- | ----------------- |
| testEstructuraCorrecta | Asegurar que la fórmula tenga números entre cada operador | Operations.MakeFormula() | true |
| testNoEmpiezaConOperador | Asegurar que la fórmula no empiece con operador | Operations.MakeFormula() | true |
| testAlMenosDosNumerosParaOperar | Asegurar que la fórmula tenga dos números para realizar la operación | Operations.MakeFormula() | true |
| testResuelveConValoresNegativos | Asegurar que se realice la operación si se envía al menos un número negativo| -2+2 | -2+2 =0|
| testValorEsperado | Asegurar que se realice la operación | 42+54*12/3 | 42+54*12/3 =258 |
| testFormulaNula | Arroja null pointer exception cuando la fórmula es null | null | exception |



## Capturas de Ejecución de Pruebas

### Lista de pruebas

![Lista de pruebas](capturas/lista_pruebas.jpg)

### Prueba Fallida: TestResuelveConValoresNegativos

![Prueba fallida](capturas/prueba_fallida.png)
