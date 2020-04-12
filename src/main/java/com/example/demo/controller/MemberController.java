package com.example.demo.controller;

import com.example.demo.entity.LibraryMember;
import com.example.demo.repository.LibraryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private LibraryMemberRepository memberRepository;

    @GetMapping("")
    public List<LibraryMember> getAllMembers() {
        return memberRepository.findAll();
    }

    @GetMapping("/{Id}")
    public LibraryMember getMemberById(@PathVariable("Id") Long Id) {
        return memberRepository.findById(Id).get();
    }


    @GetMapping("/find/")
    public List<LibraryMember> getMemberByName(@RequestParam String name) {
        return memberRepository.findAllByName(name);
    }

    @PostMapping("")
    public LibraryMember createMember(@RequestBody LibraryMember member) {
        return memberRepository.saveAndFlush(member);
    }

    @DeleteMapping("/{Id}")
    public LibraryMember deleteMember(@PathVariable("Id") Long Id) {
        memberRepository.deleteById(Id);
        return memberRepository.saveAndFlush(memberRepository.findById(Id).get());
    }

    @PutMapping("/{Id}")
    public LibraryMember updateMember(@PathVariable Long Id, @RequestBody LibraryMember member) {
        member.setId(Id);
        return memberRepository.saveAndFlush(member);
    }
}