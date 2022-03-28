package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service("speakerService")
@Profile("dev")
// scope is singleton by default
public class SpeakerServiceImpl implements SpeakerService {
    // @Autowired // field injection not recommended
    private SpeakerRepository repository;

    public SpeakerServiceImpl() {
        System.out.println("SpeakerServiceImpl no args constructor");
    }

    @Autowired // repository constructor injection autowiring
    public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
        repository = speakerRepository;
        System.out.println("SpeakerServiceImpl repository constructor");
    }

    // @Autowired // setter injection autowiring
    public void setRepository(SpeakerRepository repository) {
        this.repository = repository;
        System.out.println("SpeakerServiceImpl no args setter");
    }

    @PostConstruct
    public void initialize() {
        System.out.println("SpeakerServiceImpl initialized...");
    }

    @Override
    public List<Speaker> findAll() {
        return repository.findAll();
    }
}
