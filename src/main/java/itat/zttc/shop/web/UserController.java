package itat.zttc.shop.web;

import com.google.common.collect.Maps;
import itat.zttc.shop.model.Pager;
import itat.zttc.shop.model.User;
import itat.zttc.shop.model.UserTypeEnum;
import itat.zttc.shop.service.IUserService;
import itat.zttc.shop.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * since 2015/6/10.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("addInput")
    public String addInput() {
        return "user/addInput";
    }

    @RequestMapping(value = "addInput", method = RequestMethod.POST)
    public String addInput(User user) {
        try {
            User add = userService.add(user);
        } catch (Exception e) {

            return "user/addInput";
        }
        return "redirect:/user/list";
    }
    @RequestMapping("login")
    public String login() {
        return "user/loginInput";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest req, String username, String password) {
        User user = null;
        try {
            user = userService.login(username, password);
        } catch (Exception e) {
            return "user/loginInput";
        }
        req.getSession().setAttribute("loginUser", user);
        return "redirect:/user/list";
    }

    @RequestMapping("list")
    public String list(String name, Model model) {
        Pager<User> users = userService.find(name);
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping("show")
    public String show(int id, Model model) {
        User load = userService.load(id);
        model.addAttribute("user", load);
        return "user/show";
    }

    @RequestMapping("updateInput")
    public String updateInput(int id, Model model) {
        User load = userService.load(id);
        model.addAttribute("user", load);
        return "user/updateInput";
    }

    @RequestMapping(value = "updateInput", method = RequestMethod.POST)
    public String updateInput(User user) {
        User load = userService.update(user);
        return "redirect:/user/list";
    }

    @RequestMapping("changeType")
    public String changeType(int id) {
        User load = userService.load(id);
        if (load.getType() == UserTypeEnum.ADMIN) {
            load.setType(UserTypeEnum.USER);
        } else {
            load.setType(UserTypeEnum.ADMIN);
        }
        userService.update(load);
        return "redirect:/user/list";
    }

    @RequestMapping("delete")
    public String delete(int id, HttpServletRequest req, Model model) {
        User user = (User) req.getSession().getAttribute("loginUser");
        if (user==null ) {
            RequestUtil.check(req, "error", "没有登陆");
            return "user/loginInput";
        }
        if (user.getType() == UserTypeEnum.USER) {
            RequestUtil.check(req, "error", "权限不足");
            Pager<User> users = userService.find(null);
            model.addAttribute("users", users);
            return "user/list";
        }
        userService.delete(id);
        return "redirect:/user/list";
    }
}
