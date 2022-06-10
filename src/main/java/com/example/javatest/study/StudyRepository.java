package com.example.javatest.study;

import com.example.javatest.domain.Study;

public interface StudyRepository /** extends JpaRepository<Study, Long> */ {
    Study save(Study study);
}
