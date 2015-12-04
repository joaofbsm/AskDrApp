package com.example.joaofbsm.assignment1;

public class Medication {

    private String name;
    private String information;
    private String howToUse;
    private String sideEffects;

    public static final Medication[] medications = {
            new Medication("Dexilant", "Dexilant is used to treat certain stomach and esophagus problems (such as acid reflux). It works by decreasing the amount of acid your stomach makes. It relieves symptoms such as heartburn, difficulty swallowing, and persistent cough. This medication helps heal acid damage to the stomach and esophagus, helps prevent ulcers, and may help prevent cancer of the esophagus." , "Take this medication by mouth as directed by your doctor, usually once daily with or without food. Do not crush or chew the capsules. Swallow this medication whole.", "Diarrhea may occur. If this effect persists or worsens, tell your doctor or pharmacist promptly. This medication may rarely cause a severe intestinal condition (Clostridium difficile-associated diarrhea) due to a type of bacteria. Do not use anti-diarrhea products or narcotic pain medications if you have any of the following symptoms because these products may make them worse. Rarely, proton pump inhibitors (such as dexlansoprazole) have caused vitamin B-12 deficiency."),
            new Medication("Metoprolol Succinate", "This medication is a beta-blocker used to treat chest pain (angina), heart failure, and high blood pressure. Lowering high blood pressure helps prevent strokes, heart attacks, and kidney problems. This drug works by blocking the action of certain natural chemicals in your body (such as epinephrine) that affect the heart and blood vessels. This lowers heart rate, blood pressure, and strain on the heart. This medication may also be used for irregular heartbeats, migraine headache prevention, and after an acute heart attack to improve survival." , "Take this medication by mouth, with or right after a meal, as directed by your doctor, usually once daily. The dosage is based on your medical condition and response to treatment.Do not crush or chew extended-release tablets. Doing so can release all of the drug at once, increasing the risk of side effects. Also, do not split the tablets unless they have a score line and your doctor or pharmacist tells you to do so. Swallow the whole or split tablet without crushing or chewing." , "Drowsiness, dizziness, tiredness, diarrhea, and slow heartbeat may occur. Decreased sexual ability has been reported rarely. If any of these effects persist or worsen, tell your doctor or pharmacist promptly. To reduce the risk of dizziness and lightheadedness, get up slowly when rising from a sitting or lying position. This drug may reduce blood flow to your hands and feet, causing them to feel cold. Smoking may worsen this effect. Dress warmly and avoid tobacco use."),
            new Medication("Remeron", "Remeron is used to treat depression. It improves mood and feelings of well-being. Remeron is an antidepressant that works by restoring the balance of natural chemicals (neurotransmitters) in the brain." , "Take this medication by mouth, with or without food, usually once daily at bedtime or as directed by your doctor. The dosage is based on your medical condition and response to therapy, but should not exceed 45 milligrams per day. Use this medication regularly in order to get the most benefit from it. Remember to use it at the same time each day. It may take between 1-4 weeks to notice improvement in your symptoms. Therefore, do not increase your dose or take it more often than prescribed.", "Dizziness, drowsiness, lightheadedness, increased appetite, weight gain, dry mouth, or constipation may occur. If any of these effects persist or worsen, tell your doctor or pharmacist promptly. To relieve dry mouth, suck on (sugarless) hard candy or ice chips, chew (sugarless) gum, drink water or use a saliva substitute. This medication may increase serotonin and rarely cause a very serious condition called serotonin syndrome/toxicity. The risk increases if you are also taking other drugs that increase serotonin, so tell your doctor or pharmacist of all the drugs you take.")
    };

    public Medication(String name, String information, String howToUse, String sideEffects) {
        this.name = name;
        this.information = information;
        this.howToUse = howToUse;
        this.sideEffects = sideEffects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getHowToUse() {
        return howToUse;
    }

    public void setHowToUse(String howToUse) {
        this.howToUse = howToUse;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }
}
