package dev.anhTuan.keyCloak.service;

import jakarta.annotation.PostConstruct;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class BugTrackerService {
    private static final List<String> INITIAL_APPS = List.of("App1","App2","App3","App4","App5");

    private final AtomicReference<BugTrackerConfiguration>trackerConfig = new AtomicReference<>(new BugTrackerConfiguration(INITIAL_APPS));

    private final AtomicLong idGenerator = new AtomicLong();

    private final List<Bug>bugs = Collections.synchronizedList(new ArrayList<>());

    @PostConstruct
    public void initialize(){
        Long id = idGenerator.getAndIncrement();
        Bug b1 = new Bug(id,"anhTuan","Test does not work","Test does not work","App1",Bug.BugSeverity.MAJOR ,Bug.BugState.OPEN);
        bugs.add(b1);

        long id2 = idGenerator.getAndIncrement();
        Bug b2 = new Bug(id2,"anhTuan", "Integration does not work 1", "Integration does not work", "App2", Bug.BugSeverity.MAJOR, Bug.BugState.CLOSED);
        bugs.add(b2);

        long id3 = idGenerator.getAndIncrement();
        Bug b3 = new Bug(id3,"anhTuan", "Nullpointer exception when 0 passed", "Nullpointer exception when 0 passed", "App3", Bug.BugSeverity.CRITICAL, Bug.BugState.CLOSED);
        bugs.add(b3);

        long id4 = idGenerator.getAndIncrement();
        Bug b4 = new Bug(id4,"anhTuan", "coredump in certain situations", "coredump in certain situations", "App4", Bug.BugSeverity.MINOR, Bug.BugState.CLOSED);
        bugs.add(b4);
    }
    public Bug createBug(Bug bug){
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        OidcUser principal = (OidcUser) token.getPrincipal();

        // create a new bug
        long id = idGenerator.getAndIncrement();

        Bug clonedBug = new Bug(
                id,
                principal.getPreferredUsername(),
                bug.headline(),
                bug.description(),
                bug.project(),
                bug.bugSeverity(),
                bug.bugState()
        );
        bugs.add(clonedBug);
        return clonedBug;
    }
    public Bug updateBug(Bug bug){
        int index = IntStream.range(0,this.bugs.size())
                .filter(i -> this.bugs.get(i).id().equals(bug.id()))
                .findFirst()
                .orElseThrow();
        this.bugs.set(index,bug);
        return bug;
    }
    public List<Bug>findAllBugs(){
        return List.copyOf(this.bugs);
    }
    public boolean deleteBug(Long bugId){
        return this.bugs.removeIf(bug -> bug.id().equals(bugId));
    }
    public  Bug getBug(Long id){
        return this.bugs.stream().filter(bug->bug.id().equals(id)).findFirst().orElseThrow();
    }
    public BugTrackerConfiguration getBugTrackerConfiguration(){
        return trackerConfig.get();
    }
    public void addProject(String newProject){
        BugTrackerConfiguration configuration = trackerConfig.get();
        List<String>projects = configuration.projects();
        List<String>newApps = new ArrayList<>();
        newApps.add(newProject);
        newApps.addAll(projects);
        trackerConfig.set(new BugTrackerConfiguration(newApps));
    }
    public void removeProject(String project){
        BugTrackerConfiguration configuration = trackerConfig.get();
        List<String>applications= configuration.projects();
        List<String>newAppList = applications.stream().filter(a -> !a.equals(project)).toList();
        trackerConfig.set(new BugTrackerConfiguration(newAppList));
    }

}
