package com.example.karate20211012;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import com.intuit.karate.junit5.Karate;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CrowdSourcedUpskillingAppTests {
	@Test	void contextLoads() {
	}
}

class KarateTestsFromCommandLineRequiresRunningApp {
    @Karate.Test
	Karate testAll() {    
        return Karate.run().relativeTo(getClass());
    }
}

class KarateTestsFromCommandLineWithAppForTestCoverageParallalized {
    @Test
    void testParallel() {
        Results results = Runner.path("classpath:com.example")/*.tags("~@skipme")*/.parallel(5);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }
}

class KarateTestsFromCommandLineWithAppForTestCoverage {
    @Karate.Test
    Karate testAll() {
        SpringApplication.run(CrowdSourcedUpskillingApp.class, new String[]{});
        return Karate.run().relativeTo(getClass());
    }
}

class KarateTestsFromVSC {
    @Karate.Test
    Karate testAll() {
        return Karate.run().relativeTo(getClass());
       // Possibly return Karate.run();       
    }
}
