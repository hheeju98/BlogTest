package site.metacoding.blogtest.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;

public class PostController {
    @GetMapping({ "", "/" })
    public String list() {
        return "list";
    }
}
