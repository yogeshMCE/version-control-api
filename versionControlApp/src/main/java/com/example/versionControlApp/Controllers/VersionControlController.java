package com.example.versionControlApp.Controllers;

import com.example.versionControlApp.DTOs.Response;
import com.example.versionControlApp.DTOs.VersionDto;
import com.example.versionControlApp.Models.File;
import com.example.versionControlApp.Models.Branch;
import com.example.versionControlApp.Services.VersionControlService;
import com.example.versionControlApp.Services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/version-control")
public class VersionControlController {

    @Autowired
    private VersionControlService versionControlService;

    @Autowired
    private BranchService branchService;

    @PostMapping("/merge")
    public VersionDto merge(@RequestBody File baseFile, @RequestBody File branchFile) {
        return versionControlService.merge(baseFile, branchFile);
    }

    @GetMapping("/diff")
    public ResponseEntity<Response>  diff(@RequestBody File baseFile, @RequestBody File branchFile) {
        String ans=  versionControlService.diff(baseFile, branchFile);
        return new ResponseEntity<>(new Response(ans,true), HttpStatus.OK);

    }

    @PostMapping("/commit")
    public ResponseEntity<Response> commit(@RequestBody VersionDto versionDto, @RequestParam long fileId) {
        versionControlService.commit(versionDto, fileId);
        return new ResponseEntity<>(new Response("Version committed successfully",true), HttpStatus.OK);
    }

    @GetMapping("/hasConflict")
    public ResponseEntity<Response> hasConflict(@RequestBody File baseFile, @RequestBody File branchFile) {
        boolean ans=  versionControlService.hasConflict(baseFile, branchFile);
        return new ResponseEntity<>(new Response("Conflict exists: "+ans,ans), HttpStatus.OK);
    }
}