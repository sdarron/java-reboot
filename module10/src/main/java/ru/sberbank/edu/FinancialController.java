package ru.sberbank.edu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/finance")
@PropertySource("classpath:application.properties")
public class FinancialController {

    Calculation calculation = null;
    FinancialFields financialFields = null;

    @Value("${minSum}")
    private double minSum;
    @GetMapping
    public ModelAndView getFinanceForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/finance.jsp");
        return modelAndView;
    }

    @GetMapping("/calc")
    public ModelAndView getProfit() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("profit", calculation.getProfit());
        modelAndView.setViewName("/profit.jsp");
        return modelAndView;
    }

    @PostMapping("/calc")
    public ModelAndView profit(@RequestParam(name = "sum") String sum,
                                  @RequestParam(name = "percentage") String percentage,
                                  @RequestParam(name = "years") String years) {
        ModelAndView modelAndView = new ModelAndView();
            try {
                financialFields  = new FinancialFields(Integer.parseInt(years), Double.parseDouble(sum), Double.parseDouble(percentage));
            } catch (NumberFormatException ex) {
                modelAndView.setViewName("/errordata.jsp");
                return modelAndView;
            }
            if ( financialFields.getSum() < 0 || financialFields.getYears() < 0 || financialFields.getPercentage() < 0) {
                modelAndView.setViewName("/errordata.jsp");
                return modelAndView;
            }
            if (financialFields.getSum() < minSum){
                modelAndView.addObject("minSum", minSum);
                modelAndView.setViewName("/errorsum.jsp");
                return modelAndView;
            } else {
                calculation = new Calculation(financialFields);
                modelAndView.addObject("profit", calculation.getProfit());
                modelAndView.setViewName("/profit.jsp");
            }
            return modelAndView;
    }

}
