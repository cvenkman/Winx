package org.app.controllers;

import org.app.dao.WinxDao;
import org.app.models.Fairy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;

/**
 * Created by cvenkman on Mar, 2022
 **/
@Controller
@RequestMapping("/winx")
public class WinxController {
    private final WinxDao winxDao;

    @Autowired
    public WinxController(WinxDao winxDao) {
        this.winxDao = winxDao;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("allWinx", winxDao.index());
        return "winx/index";
    }

    @GetMapping("/{name}")
    public String show(@PathVariable("name") String name,
                       Model model) {
        model.addAttribute("fairy", winxDao.show(name));
        return "winx/show";
    }

    @GetMapping("/new")
    public String newFairy(@ModelAttribute("fairy") Fairy fairy) { // нужна ли тут модель
        return "winx/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("fairy") @Valid Fairy fairy,
                         BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors())
            return "winx/new";

        winxDao.save(fairy);
        return "redirect:/winx";
    }

    @DeleteMapping("/{name}")
    public String delete(@PathVariable("name") String name) {
        winxDao.delete(name);
        return "redirect:/winx";
    }

    @GetMapping("/{name}/edit")
    public String edit(Model model, @PathVariable("name") String name) {
        model.addAttribute("fairy", winxDao.show(name));
        return "winx/edit";
    }

    @PatchMapping("/{name}")
    public String update(@ModelAttribute("fairy") @Valid Fairy fairy,
                         BindingResult bindingResult,
                         @PathVariable("name") String name) {
        if (bindingResult.hasErrors())
            return "winx/edit";

        winxDao.update(name, fairy);
        return "redirect:/winx";
    }

    @GetMapping("/ping-pong")
    public String newFairy(@ModelAttribute("fairy") Fairy fairy) {// нужна ли тут модель
        return "games/ping-pong";
    }

    @GetMapping("/snake")
    public String newFairy(@ModelAttribute("fairy") Fairy fairy) {// нужна ли тут модель
        return "games/snakeGame";
    }
}
