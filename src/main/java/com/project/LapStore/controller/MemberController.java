package com.project.LapStore.controller;

import com.project.LapStore.domain.Member;
import com.project.LapStore.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.thymeleaf.spring5.processor.SpringInputCheckboxFieldTagProcessor;

import java.io.*;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final String FILE_PATH = "/Users/zooputer/Desktop/Repository/LapStore/src/main/resources/joinMembers.txt";
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void outputMenu() throws IOException {
        System.out.println();
        System.out.println("-----실행할 메뉴의 숫자를 입력하세요.-----");
        System.out.println("[1] 모든 회원 조회");
        System.out.println("[2] 특정 회원 조회");
        System.out.println("[3] 회원 가입");
        System.out.println("[4] 종료");
        System.out.println("-------------------------------------------");

        int menuNum = Integer.parseInt(br.readLine());
        switch (menuNum) {
            case 1:
                System.out.println("모든 회원을 조회합니다.\n");
                findMembers();
                break;
            case 2:
                System.out.println("조회할 회원의 Id 를 입력하세요.\n");
                Long memberId = Long.parseLong(br.readLine());
                findOne(memberId);
                break;
            case 3:
//                System.setIn(new FileInputStream(FILE_PATH));
                System.out.println("회원가입 정보를 입력하세요.\n");

                br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = new StringTokenizer(br.readLine());
                Long id = memberService.numMembers() + 1;
                String userid = st.nextToken();
                String pwd = st.nextToken();
                String name = st.nextToken();
                String email = st.nextToken();
                String phone = st.nextToken();
                LocalDateTime dateJoined = LocalDateTime.now();
                boolean isAdministrator = false;

                Member newMember = new Member(id, userid, pwd, name, email, phone, dateJoined, isAdministrator);
                join(newMember);
                System.out.println(name + " 님의 회원가입이 완료되었습니다.\n");
                break;
            case 4:
                System.exit(0);
        }

    }

    private void join(Member newMember) {
        memberService.join(newMember);
    }

    private void findMembers() {
        memberService.findMembers().forEach(System.out::println);
    }

    private void findOne(Long memberId) throws IOException {
        System.out.println(memberService.findOne(memberId));
    }

//    @GetMapping("/members/new")
//    public String createForm(Model model) {
//        model.addAttribute("memberForm", new MemberForm());
//        return "members/createMemberForm";
//    }
//
//    @PostMapping("/members/new")
//    public String create(@Valid MemberForm form, BindingResult result) {
//
//        if (result.hasErrors()) {
//            return "members/createMemberForm";
//        }
//
//        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());
//
//        Member member = new Member();
//        member.setName(form.getName());
//        member.setAddress(address);
//
//        memberService.join(member);
//        return "redirect:/";
//    }
//
//    @GetMapping("/members")
//    public String list(Model model) {
//        List<Member> members = memberService.findMembers();
//        model.addAttribute("members", members);
//        return "members/memberList";
//    }

}
