package bstorm.akimts.CorrectionExo1;

import bstorm.akimts.CorrectionExo1.repository.SectionRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class TestRepo implements InitializingBean {

    private SectionRepository repo;

    public TestRepo(SectionRepository repo) {
        this.repo = repo;
    }

    public void test(){
        repo.getOne(100);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        test();
    }
}
