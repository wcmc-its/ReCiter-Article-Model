/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/
package reciter.engine.erroranalysis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import reciter.model.article.ReCiterArticle;

/**
 * Class that performs analysis such as calculating precision and recall.
 *
 * @author jil3004
 */
public class Analysis {

    private double precision;
    private double recall;

    private int truePos;
    private int trueNeg;
    private int falseNeg;
    private int falsePos;
    private int goldStandardSize;
    private List<Long> truePositiveList = new ArrayList<>();
    private List<Long> trueNegativeList = new ArrayList<>();
    private List<Long> falsePositiveList = new ArrayList<>();
    private List<Long> falseNegativeList = new ArrayList<>();

	/**
		Assigns goldstandards based on acceptedPmids and Rejected pmids.
	*/
    public static void assignGoldStandard(List<ReCiterArticle> reCiterArticles, List<Long> acceptedPmids, List<Long> rejectedPmids) {
        Set<Long> pmidSet = new HashSet<>();
        if(acceptedPmids != null && !acceptedPmids.isEmpty()) {
	        acceptedPmids.stream().forEach(acceptedPmid -> pmidSet.add(acceptedPmid));
        }

        for (ReCiterArticle reCiterArticle : reCiterArticles) {
            if (pmidSet.contains(reCiterArticle.getArticleId())) {
                reCiterArticle.setGoldStandard(1);
            } 
        }
        if (rejectedPmids != null) {
            if (!pmidSet.isEmpty()) {
                pmidSet.clear();
            }
            rejectedPmids.stream().forEach(rejectedPmid -> pmidSet.add(rejectedPmid));

            for (ReCiterArticle reCiterArticle : reCiterArticles) {
                if (pmidSet.contains(reCiterArticle.getArticleId())) {
                    reCiterArticle.setGoldStandard(-1);
                }
            }
        }

    }
	/**
		Performs the analysis based articles gold standards
	*/
    public static Analysis performAnalysis(List<ReCiterArticle> reCiterArticles,List<Long> goldStandardPmids) {

        Analysis analysis = new Analysis();
        if(goldStandardPmids != null && !goldStandardPmids.isEmpty()) {
	        analysis.setGoldStandardSize(goldStandardPmids.size());
	        
	        for (ReCiterArticle reCiterArticle : reCiterArticles) {
		        if (reCiterArticle.getGoldStandard() == 1 && reCiterArticle.getAuthorshipLikelihoodScore() >= 50.0000 && goldStandardPmids.contains(reCiterArticle.getArticleId())) {
		            analysis.getTruePositiveList().add(reCiterArticle.getArticleId());
		        } else if (reCiterArticle.getGoldStandard() == -1 && reCiterArticle.getAuthorshipLikelihoodScore() < 50.0000) {
		        	 analysis.getTrueNegativeList().add(reCiterArticle.getArticleId());
		        } else if (reCiterArticle.getGoldStandard() == -1 && reCiterArticle.getAuthorshipLikelihoodScore() >= 50.0000 && !goldStandardPmids.contains(reCiterArticle.getArticleId())) {
		            analysis.getFalsePositiveList().add(reCiterArticle.getArticleId());
		        } else if (reCiterArticle.getGoldStandard() == -1 && reCiterArticle.getAuthorshipLikelihoodScore() < 50.0000 && goldStandardPmids.contains(reCiterArticle.getArticleId())){
		        	analysis.getFalseNegativeList().add(reCiterArticle.getArticleId());
		        }
	    	
	        }
		
	        analysis.setTruePos(analysis.getTruePositiveList().size());
	        analysis.setTrueNeg(analysis.getTrueNegativeList().size());
	        analysis.setFalseNeg(analysis.getFalseNegativeList().size());
	        analysis.setFalsePos(analysis.getFalsePositiveList().size());
	        analysis.setPrecision(analysis.getPrecision());
	        analysis.setRecall(analysis.getRecall());
        }
        return analysis;
    }
    /**
		Getter for precision
	*/
    public double getPrecision() {
    	if (truePos + falseNeg == 0) 
              return 0;
    	return (double) truePos / (truePos + falsePos);
    }
	/**
		Setter for precision
	*/
    public void setPrecision(double precision) {
        this.precision = precision;
    }
	/**
		Getter for Recall
	*/
    public double getRecall() {
        if (truePos + falseNeg == 0) 
            return 0;
        return (double) truePos / (truePos + falseNeg);
    	
    }
	/**
		Setter for Recall
	*/
    public void setRecall(double recall) {
        this.recall = recall;
    }
    /**
		getter for accuracy
	*/
    public double getAccuracy() {
		return (this.precision + this.recall)/2;
	}
	/**
		Getter for TruePos
	*/
	public int getTruePos() {
        return truePos;
    }
	/**
		Setter for the TruePos
	*/
    public void setTruePos(int truePos) {
        this.truePos = truePos;
    }
	/**
		Getter for the goldstandard size
	*/
    public int getGoldStandardSize() {
        return goldStandardSize;
    }
	/**
		Setter for the gold standard Size
	*/
    public void setGoldStandardSize(int goldStandardSize) {
        this.goldStandardSize = goldStandardSize;
    }
	/**
		Getter for the FalsePoistiveList
	*/
    public List<Long> getFalsePositiveList() {
        return falsePositiveList;
    }
	/**
		Setter for the FalsePositive list
	*/
    public void setFalsePositiveList(List<Long> falsePositiveList) {
        this.falsePositiveList = falsePositiveList;
    }
	/**
		Getter for the False negative List
	*/
    public List<Long> getFalseNegativeList() {
        return falseNegativeList;
    }
	/**
		Setter for the False nagative List 
	*/
    public void setFalseNegativeList(List<Long> falseNegativeList) {
        this.falseNegativeList = falseNegativeList;
    }
	/**
		Getter for the False negative
	*/
    public int getFalseNeg() {
        return falseNeg;
    }
	/**
		Setter for the False negative
	*/
    public void setFalseNeg(int falseNeg) {
        this.falseNeg = falseNeg;
    }
	/**
		Getter for the trueneg
	*/
    public int getTrueNeg() {
        return trueNeg;
    }
	/**
		Setter for the trueneg
	*/
    public void setTrueNeg(int trueNeg) {
        this.trueNeg = trueNeg;
    }
	/**
		Getter for the False position
	*/
    public int getFalsePos() {
        return falsePos;
    }
	/**
		Setter for the false position
	*/
    public void setFalsePos(int falsePos) {
        this.falsePos = falsePos;
    }
	/**
		Getter for the true positive list
	*/
    public List<Long> getTruePositiveList() {
        return truePositiveList;
    }
	/**
		Setter for true positive List
	*/
    public void setTruePositiveList(List<Long> truePositiveList) {
        this.truePositiveList = truePositiveList;
    }
	/**
		Getter for the True negative List
	*/
    public List<Long> getTrueNegativeList() {
        return trueNegativeList;
    }
	/**
		Setter for the true negative list
	*/
    public void setTrueNegativeList(List<Long> trueNegativeList) {
        this.trueNegativeList = trueNegativeList;
    }
	/**
		Overrides toString method for representation
	*/
    @Override
    public String toString() {
        return "Analysis [precision=" + precision + ", recall=" + recall + ", truePos=" + truePos + ", trueNeg="
                + trueNeg + ", falseNeg=" + falseNeg + ", falsePos=" + falsePos + ", goldStandardSize="
                + goldStandardSize + ", truePositiveList="
                + truePositiveList + ", trueNegativeList=" + trueNegativeList + ", falsePositiveList="
                + falsePositiveList + ", falseNegativeList=" + falseNegativeList + "]";
    }

}
