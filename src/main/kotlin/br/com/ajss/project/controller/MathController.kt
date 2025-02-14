package br.com.ajss.project.controller

import br.com.ajss.project.exceptions.UnsupportedMathOperationException
import br.com.ajss.project.helper.ConversorHelper
import br.com.ajss.project.math.SimpleMath
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MathController {

    private val math: SimpleMath = SimpleMath()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {
        if(!ConversorHelper.isNumeric(numberOne) || !ConversorHelper.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return math.sum(ConversorHelper.convertToDouble(numberOne), ConversorHelper.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/sub/{numberOne}/{numberTwo}"])
    fun sub(@PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {
        if(!ConversorHelper.isNumeric(numberOne) || !ConversorHelper.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return math.sub(ConversorHelper.convertToDouble(numberOne), ConversorHelper.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/mult/{numberOne}/{numberTwo}"])
    fun mult(@PathVariable(value="numberOne") numberOne: String?,
             @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {
        if(!ConversorHelper.isNumeric(numberOne) || !ConversorHelper.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return math.mult(ConversorHelper.convertToDouble(numberOne), ConversorHelper.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/div/{numberOne}/{numberTwo}"])
    fun div(@PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {
        if(!ConversorHelper.isNumeric(numberOne) || !ConversorHelper.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        if(ConversorHelper.convertToDouble(numberTwo) == 0.0)
            throw UnsupportedMathOperationException("Division by zero is not allowed!")
        return math.division(ConversorHelper.convertToDouble(numberOne), ConversorHelper.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/avg/{numberOne}/{numberTwo}"])
    fun avg(@PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {
        if(!ConversorHelper.isNumeric(numberOne) || !ConversorHelper.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return math.avg(ConversorHelper.convertToDouble(numberOne), ConversorHelper.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/sqrt/{number}"])
    fun sqrt(@PathVariable(value="number") number: String?): Double {
        if(!ConversorHelper.isNumeric(number))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return math.sqrt(ConversorHelper.convertToDouble(number))
    }
}