package com.example.hr.dto.employee;

import com.example.hr.domain.employee.Job;

public record JobResponse(String jobId, String jobTitle) {

    public static JobResponse of(Job job){
        return new JobResponse(job.getJobId(), job.getJobTitle());
    }
}
