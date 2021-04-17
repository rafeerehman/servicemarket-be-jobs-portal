package com.jobs.portal.jobsportal.controller;

import com.jobs.portal.jobsportal.business.base.CountryBusiness;
import com.jobs.portal.jobsportal.business.base.JobBusiness;
import com.jobs.portal.jobsportal.request.BaseRequest;
import com.jobs.portal.jobsportal.request.JobApplyRequest;
import com.jobs.portal.jobsportal.request.JobPostRequest;
import com.jobs.portal.jobsportal.response.BaseResponse;
import com.jobs.portal.jobsportal.service.base.JobService;
import com.jobs.portal.jobsportal.service.impl.TransactionLoggerService;
import com.jobs.portal.jobsportal.util.ConfigurationUtil;
import com.jobs.portal.jobsportal.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    JobService service;

    @Autowired
    ConfigurationUtil configurationUtil;


    @Autowired
    JobBusiness business;

    @Autowired
    CountryBusiness countryBusiness;

    @Autowired
    TransactionLoggerService transactionLoggerService;

    @PostMapping("/job-shift")
    public ResponseEntity<BaseResponse> login(@Valid @RequestBody BaseRequest request)throws Exception{

        BaseResponse responseObject = business.getJobShift(request);

                transactionLoggerService.log(request.getTransactionId(), "/portal/job/job-shift",
                request, responseObject, configurationUtil.getMessage(Constants.POST_REQUEST_RESPONSE_CODE));


        return ResponseEntity.ok(responseObject);
    }

    @PostMapping("/job-type")
    public ResponseEntity<BaseResponse> getJobType(@Valid @RequestBody BaseRequest request)throws Exception{

        BaseResponse responseObject = business.getJobShift(request);

                transactionLoggerService.log(request.getTransactionId(), "/portal/job/job-shift",
                request, responseObject, configurationUtil.getMessage(Constants.POST_REQUEST_RESPONSE_CODE));
        return ResponseEntity.ok(responseObject);

    }


    @PostMapping("/post-job")
    public ResponseEntity<BaseResponse> postJob(@Valid @RequestBody JobPostRequest request)throws Exception{

        BaseResponse responseObject = business.getJobShift(request);

                transactionLoggerService.log(request.getTransactionId(), "/portal/job/job-shift",
                request, responseObject, configurationUtil.getMessage(Constants.POST_REQUEST_RESPONSE_CODE));
        return ResponseEntity.ok(responseObject);

    }


    @PostMapping("/job")
    public ResponseEntity<BaseResponse> getJobs(@Valid @RequestBody BaseRequest request)throws Exception{

        BaseResponse responseObject = business.getJobShift(request);

                transactionLoggerService.log(request.getTransactionId(), "/portal/job/job-shift",
                request, responseObject, configurationUtil.getMessage(Constants.POST_REQUEST_RESPONSE_CODE));

        return ResponseEntity.ok(responseObject);
    }

    @PostMapping("/apply-job")
    public ResponseEntity<BaseResponse> applyJob(@Valid @RequestBody JobApplyRequest request)throws Exception{
        BaseResponse responseObject = business.getJobShift(request);

                transactionLoggerService.log(request.getTransactionId(), "/portal/job/job-shift",
                request, responseObject, configurationUtil.getMessage(Constants.POST_REQUEST_RESPONSE_CODE));


        return ResponseEntity.ok(responseObject);    }

}
