package se.jensensthlm.forexgump;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/exchange")
public class ExchangeController {
    private ExchangeCalculator exchangeCalculator = new ExchangeCalculator(new ForexExchangeProvider());

    @GetMapping("/buy/{currency}/{amount}")
    public ResponseEntity<ExchangeBuyOutputDto> buy(@PathVariable String currency, @PathVariable double amount) {
        var amountToPay = exchangeCalculator.calculateBuy(currency, amount);
        var responseBody = new ExchangeBuyOutputDto(exchangeCalculator.getReferenceCurrency(), amountToPay);
        return ResponseEntity.ok().body(responseBody);
    }

    @GetMapping("/sell/{currency}/{summa}")
    public ResponseEntity<ExchangeSellOutputDto> sell(@PathVariable String currency, @PathVariable("summa") double amount) {
        var amountToGet = exchangeCalculator.calculateSell(currency, amount);
        var responseBody = new ExchangeSellOutputDto(exchangeCalculator.getReferenceCurrency(), amountToGet);
        return ResponseEntity.ok().body(responseBody);
    }
}
