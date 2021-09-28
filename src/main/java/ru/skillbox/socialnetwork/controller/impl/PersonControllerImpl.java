package ru.skillbox.socialnetwork.controller.impl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skillbox.socialnetwork.controller.PersonController;
import ru.skillbox.socialnetwork.data.dto.PersonRequest;
import ru.skillbox.socialnetwork.data.dto.PersonResponse;
import ru.skillbox.socialnetwork.data.repository.PersonRepo;
import ru.skillbox.socialnetwork.service.PersonService;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@Tag(name = "Работа с профилем")
public class PersonControllerImpl implements PersonController {

    private final PersonService personService;
    @Autowired
    private final PersonRepo personRepo;
    private final Logger logger = LoggerFactory.getLogger(PersonControllerImpl.class);

    @Override
    @GetMapping("/me")
    //   @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<PersonResponse> getPersonDetail(Principal principal) {
        logger.info("Call GET /api/v1/users/me");
        return ResponseEntity.ok(personService.getPersonDetail(principal));
    }

    @Override
    @PutMapping("/me")
    public ResponseEntity<PersonResponse> putPersonDetail(@Valid @RequestBody PersonRequest personRequest, Principal principal) {
        logger.info("Call PUT /api/v1/users/me");
        return ResponseEntity.ok(personService.putPersonDetail(personRequest, principal));
    }

    @Override
    @DeleteMapping("/me")
    public ResponseEntity<PersonResponse> deletePerson(Principal principal) {
        logger.info("Call DELETE /api/v1/users/me");
        return ResponseEntity.ok(personService.deletePerson(principal));
    }

}