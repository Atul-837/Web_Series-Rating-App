package com.dev_ak.web_series.controller;

import com.dev_ak.web_series.entity.Review;
import com.dev_ak.web_series.entity.WebSeries;
import com.dev_ak.web_series.service.ReviewService;
import com.dev_ak.web_series.service.WebSeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AppController {
    private final WebSeriesService webSeriesService;
    private final ReviewService reviewService;

    @GetMapping("/")
    public String mainPage(Model model) {
        List<WebSeries> webSeries = this.webSeriesService.getAllWebSeries();
        model.addAttribute("webSeries", webSeries);
        return "main";
    }

    @GetMapping("/addnewseries")
    public String addNewSeries(Model model) {
        WebSeries webSeries = new WebSeries();
        model.addAttribute("webSeries", webSeries);
        return "addnewseries";
    }

    @PostMapping("/addnewseries")
    public String addNewSeries(@ModelAttribute WebSeries webSeries) {
        this.webSeriesService.createWebSeries(webSeries);
        return "redirect:/";
    }

    @GetMapping("/reviews/{your_series}")
    public String reviews(@PathVariable("your_series") Long id, Model model) {
        Optional<WebSeries> series = this.webSeriesService.getById(id);
        if (series.isPresent()) {
            WebSeries webSeries = series.get();
            List<Review> reviews = this.reviewService.getAllById(id);
            model.addAttribute("webSeries", webSeries);
            model.addAttribute("reviews", reviews);
        }
        return "reviews";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/reviews/{your_series}/create_review")
    public String createReview(@PathVariable("your_series") Long id, Model model) {
        Optional<WebSeries> series = this.webSeriesService.getById(id);
        if (series.isPresent()) {
            WebSeries webSeries = series.get();
            Review review = new Review();
            model.addAttribute("webSeries", webSeries);
            model.addAttribute("review", review);
        }
        return "createreview";
    }

    @PostMapping("/reviews/{id}/create_review")
    public String createReview(@ModelAttribute Review review1, @PathVariable Long id, Model model) {
        Optional<WebSeries> series = this.webSeriesService.getById(id);
        if (series.isPresent()) {
            WebSeries webSeries = series.get();
            this.reviewService.createReview(review1, id);
            model.addAttribute("webSeries", webSeries);
        }
        return "redirect:/reviews/{id}";
    }
}
