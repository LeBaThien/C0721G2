package shop.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import shop.demo.model.Cart;

@Controller
public class ShoppingCartController {
    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("page/shoping-cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }

    @PostMapping("/shopping-cart")
    public ModelAndView saveProductCart (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("page/shoping-cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }

}
