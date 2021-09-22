/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datacenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;
import objmodels.Candidate;
import objmodels.Recruiter;

/**
 *
 * @author Eagle
 */
public class Data {
    
    //Defintion data
    public static List<Recruiter> lstRecruiters = new ArrayList<>();
    public static List<String> lstRecruiterNames = Arrays.asList("None");
    
    public static HashMap<String, String> lstResumeUpd = new HashMap<String, String>();
    public static List<String> lstResumeUpdNames = Arrays.asList("None");
    
    public static List<String> lstLocators = Arrays.asList("None");
    public static List<String> lstTitles =  Arrays.asList("None");
    public static List<String> lstStatus =  Arrays.asList("None");
    public static List<String> lstExperiences =  Arrays.asList("None");
    public static List<String> lstLabels = Arrays.asList("None");
    public static List<String> lstReferrals = Arrays.asList("None");
    public static List<String> lstCVDate = Arrays.asList("None");

    public static List<Candidate> lstCandidates = new ArrayList<>();
     
    //Load Defintion XML to get lstRecruiter, lstLocators, lstTitles, lstCVUpdate
    public static void loadDefinitionData(){
        
       lstRecruiterNames = Arrays.asList("VietNamWork","ITviet"); //////
       lstLocators = Arrays.asList("TP HCM","Da Nang", "Hue");
       lstStatus = Arrays.asList("New","Screening", "Passed screen", "Failed screeb", "Approaching", "Reject interview", "Interviewing", "Failed test/interview", "Offering", "Rejected offer", "Accepted offer", "Reject onboard", "Onboard");
      
       lstResumeUpd = new HashMap<>();
       lstResumeUpd.put("Any","Any");
       lstResumeUpd.put("Today","0");
       lstResumeUpd.put("Yesterday", "1");
       lstResumeUpd.put("1 week(s)", "7");
       lstResumeUpd.put("2 week(s)", "14");
       lstResumeUpd.put("1 month(s)", "30");
       lstResumeUpd.put("2 month(s)", "60");
       lstResumeUpd.put("6 month(s)", "180");
       lstResumeUpd.put("12 month(s)", "360");
    }
    
     public void Update(){
         lstRecruiterNames = lstRecruiters.stream().distinct().map(Recruiter::getName).collect(Collectors.toList());
         lstResumeUpdNames = new ArrayList<>(lstResumeUpd.keySet());
         lstReferrals  = lstCandidates.stream().distinct().map(Candidate::getReferral).collect(Collectors.toList());
         lstTitles  = lstCandidates.stream().distinct().map(Candidate::getJob_title).collect(Collectors.toList());
         lstExperiences= lstCandidates.stream().distinct().map(Candidate::getExp_year).collect(Collectors.toList());
         lstLabels=lstCandidates.stream().distinct().map(Candidate::getLabel).collect(Collectors.toList());
         
         
     }
    
    
 
    
}
