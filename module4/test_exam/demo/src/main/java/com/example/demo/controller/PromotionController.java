package com.example.demo.controller;


import com.example.demo.model.Promotion;
import com.example.demo.service.promotion.IPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class PromotionController {
    @Autowired
    private IPromotionService promotionService;

    @GetMapping("/search-by-discount")
    public ModelAndView searchPromotionByDiscount(@RequestParam("discount") String discount) {

        Iterable<Promotion> promotion = promotionService.findPromotionByDiscount(discount);
        ModelAndView modelAndView = new ModelAndView("/promotion/list");
        modelAndView.addObject("promotion", promotion);
        return modelAndView;
    }

    @GetMapping("/search-by-date-end")
    public ModelAndView searchPromotionByDateEnd(@RequestParam("date-end") String dateEnd) {

        Iterable<Promotion> promotion = promotionService.findPromotionByDateEnd(dateEnd);
        ModelAndView modelAndView = new ModelAndView("/promotion/list");
        modelAndView.addObject("promotion", promotion);
        return modelAndView;
    }

    @GetMapping("/search-by-date-start")
    public ModelAndView searchPromotionByDateStart(@RequestParam("date-start") String dateStart) {

        Iterable<Promotion> promotion = promotionService.findPromotionByDateStart(dateStart);
        ModelAndView modelAndView = new ModelAndView("/promotion/list");
        modelAndView.addObject("promotion", promotion);
        return modelAndView;
    }

//    @GetMapping("/search-by-all")
//    public ModelAndView search(@RequestParam("date-start") String dateStart) {
//
//
//
//        Iterable<Promotion> promotion = promotionService.findPromotionByDateStart(dateStart );
//        ModelAndView modelAndView = new ModelAndView("/promotion/list");
//        modelAndView.addObject("promotion", promotion);
//        return modelAndView;
//    }


    @GetMapping("/create-promotion")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/promotion/create");
        modelAndView.addObject("promotion", new Promotion());
        return modelAndView;
    }

    @PostMapping("/create-promotion")
//    N??n d??ng string ,,, ch??? ko d??ng modelandview, d??ng string gi??? l???i d??? li???u ??ang t???o m???i,
    public String saveShowtime(@Valid @ModelAttribute("promotion") Promotion promotion,
                               BindingResult bindingResult,
                               Model model) {
        new Promotion().validate(promotion, bindingResult);
        if (bindingResult.hasFieldErrors()) {

            return "promotion/create";

        } else {
            promotionService.save(promotion);
//        ModelAndView modelAndView = new ModelAndView("/customer/create");
//        d??ng redirect ch??? n??y n?? c?? th??? t???o li??n t???c ???????c
//            ModelAndView modelAndView = new ModelAndView("customer/create");
            model.addAttribute("promotion", new Promotion());
            model.addAttribute("message", "New promotion created successfully !!!");
            return "promotion/create";
        }

    }

    @GetMapping("/promotion")
    public String listPromotion(Optional<Promotion> promotion,
                                Model model) {
        model.addAttribute("promotion", promotionService.findAll());
        return "/promotion/list";
    }

//    @GetMapping("/index")
//    public ModelAndView list() {
////        Iterable<Customer> customers = customerService.findAll();
//        ModelAndView modelAndView = new ModelAndView("/page/index");
////        modelAndView.addObject("customers", customers);
//        return modelAndView;
//    }


    //    @GetMapping("/edit-showtime/{id}")
//    public ModelAndView showEditForm(@PathVariable int id) {
//        Optional<Promotion> showtime = showtimeService.findById(id);
//        Iterable<Film> films = filmService.findAll();
//        if (showtime.isPresent()) {
//            ModelAndView modelAndView = new ModelAndView("/showtime/edit");
//            modelAndView.addObject("showtime", showtime.get());
//            modelAndView.addObject("film", films );
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
////
//    @PostMapping("/edit-showtime")
//    public String updateShowtime(@Valid @ModelAttribute("showtime") Promotion showtime,
//                                 BindingResult bindingResult, Model model ) {
////        new Customer().validate(customer, bindingResult);
////        if(bindingResult.hasFieldErrors()){
//////            Th??m c??i n??y th?? n???u load l???i trang s??? k??m d??? li???u, lo???i kh??ch h??ng, n??n s??? ko m???t
////            Iterable<CustomerType> customerTypes = customerTypeService.findAll();
////            model.addAttribute("customerType", customerTypes );
////            return "customer/edit";
////        }else {
//            showtimeService.save(showtime);
////            ModelAndView modelAndView = new ModelAndView("/customer/edit");
//            model.addAttribute("showtime", showtime);
//            model.addAttribute("message", "Showtime updated successfully");
//            return "showtime/edit";
////        }
//
//    }
//
    @GetMapping("/delete-promotion/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        Optional<Promotion> promotion = promotionService.findById(id);
        if (promotion.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/promotion/delete");
            modelAndView.addObject("promotion", promotion.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-promotion")
    public String deletePromotion(@ModelAttribute("promotion") Promotion promotion) {
        promotionService.remove(promotion.getId());
        return "redirect:promotion";
    }

}
