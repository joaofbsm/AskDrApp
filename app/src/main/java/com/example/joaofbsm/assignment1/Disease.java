package com.example.joaofbsm.assignment1;

/**
 * Disease Class and list of diseases information
 */
public class Disease {

    private String name;
    private String description;
    private String symptoms;
    private String causes;

    // Stored diseases information
    public static final Disease[] diseases = {
            new Disease("Acute sinusitis", "Acute sinusitis (acute rhinosinusitis) causes the cavities around your nasal passages (sinuses) to become inflamed and swollen. This interferes with drainage and causes mucus to build up.\n\n With acute sinusitis, it may be difficult to breathe through your nose. The area around your eyes and face may feel swollen, and you may have throbbing facial pain or a headache.\n\n Acute sinusitis is most often caused by the common cold. Other triggers include allergies, bacterial and fungal infections. Treatment of acute sinusitis depends on the cause. In most cases, home remedies are all that's needed. However, persistent sinusitis can lead to serious infections and other complications. Sinusitis that lasts more than eight weeks or keeps coming back is called chronic sinusitis.", "Acute sinusitis symptoms often include:\n\n - Drainage of a thick, yellow or greenish discharge from the nose or down the back of the throat\n - Nasal obstruction or congestion, causing difficulty breathing through your nose\n - Pain, tenderness, swelling and pressure around your eyes, cheeks, nose or forehead\n - Reduced sense of smell and taste\n - Cough, which may be worse at night\n\nOther signs and symptoms can include:\n\n - Ear pain\n - Headache\n - Aching in your upper jaw and teeth\n - Bad breath (halitosis)\n - Fatigue\n - Fever", "When you have sinusitis, the mucous membranes of your nose, sinuses and throat (upper respiratory tract) become inflamed. Swelling obstructs the sinus openings and prevents mucus from draining normally, causing facial pain and other sinusitis symptoms.\n\nBlocked sinuses create a moist environment that makes it easier for infection to take hold. Sinuses that become infected and can't drain become pus filled, leading to signs and symptoms such as thick, yellow or greenish discharge and other symptoms of infection.\n\nAcute sinusitis can be caused by:\n\n- Viral infection. Most cases of acute sinusitis are caused by the common cold.\n- Bacterial infection. When an upper respiratory tract infection persists longer than seven to 10 days, it's more likely to be caused by a bacterial infection than by a viral infection.\n- Fungal infection. You're at increased risk of a fungal infection if you have sinus abnormalities or a weakened immune system.\n\nSome health conditions can increase your risk of getting a sinus infection that causes sinusitis, or can increase your risk of getting sinusitis that isn't caused by an underlying infection. These conditions include:\n\n- Allergies such as hay fever. Inflammation that occurs with allergies may block your sinuses.\n- Nasal polyps or tumors. These tissue growths may block the nasal passages or sinuses.\n- Deviated nasal septum. A crooked septum — the wall between the nostrils — may restrict or block sinus passages.\n- Tooth infection. A small number of cases of acute sinusitis are caused by an infected tooth.\n- Other medical conditions. The complications of cystic fibrosis, gastroesophageal reflux disease (GERD) or immune system disorders may result in blocked sinuses or an increased risk of infection."),
            new Disease("Inflammatory breast cancer", "Inflammatory breast cancer is a rare type of breast cancer that develops rapidly, making the affected breast red, swollen and tender.\n\nInflammatory breast cancer occurs when cancer cells block the lymphatic vessels in skin covering the breast, causing the characteristic red, swollen appearance of the breast.\n\nInflammatory breast cancer is considered a locally advanced cancer — meaning it has spread from its point of origin to nearby tissue and possibly to nearby lymph nodes.\n\nInflammatory breast cancer can easily be confused with a breast infection. Seek medical attention promptly if you notice skin changes on your breast, to help distinguish a breast infection from other breast disorders, such as inflammatory breast cancer.", "Signs and symptoms of inflammatory breast cancer include:\n\n - Rapid change in the appearance of one breast, over the course of several weeks\n - Thickness, heaviness or visible enlargement of one breast\n - Discoloration, giving the breast a red, purple, pink or bruised appearance\n - Unusual warmth of the affected breast\n - Dimpling or ridges on the skin of the affected breast, similar to an orange peel\n - Tenderness, pain or aching\n - Enlarged lymph nodes under the arm, above the collarbone or below the collarbone\n - Flattening or turning inward of the nipple\n - Inflammatory breast cancer doesn't commonly form a lump, as occurs with other forms of breast cancer.", "It's not clear what causes inflammatory breast cancer.\n\nDoctors know that inflammatory breast cancer begins with an abnormal cell in one of the breast's ducts. Mutations within the abnormal cell's DNA instruct it to grow and divide rapidly. The accumulating abnormal cells infiltrate and clog the lymphatic vessels in the skin of your breast. The blockage in the lymphatic vessels causes red, swollen and dimpled skin — a classic sign of inflammatory breast cancer."),
            new Disease("Tuberculosis", "Tuberculosis (TB) is a potentially serious infectious disease that mainly affects your lungs. The bacteria that cause tuberculosis are spread from one person to another through tiny droplets released into the air via coughs and sneezes.\n\nOnce rare in developed countries, tuberculosis infections began increasing in 1985, partly because of the emergence of HIV, the virus that causes AIDS. HIV weakens a person's immune system so it can't fight the TB germs. In the United States, because of stronger control programs, tuberculosis began to decrease again in 1993, but remains a concern.\n\nMany strains of tuberculosis resist the drugs most used to treat the disease. People with active tuberculosis must take several types of medications for many months to eradicate the infection and prevent development of antibiotic resistance.", "Although your body may harbor the bacteria that cause tuberculosis, your immune system usually can prevent you from becoming sick. For this reason, doctors make a distinction between:\n\nLatent TB. In this condition, you have a TB infection, but the bacteria remain in your body in an inactive state and cause no symptoms. Latent TB, also called inactive TB or TB infection, isn't contagious. It can turn into active TB, so treatment is important for the person with latent TB and to help control the spread of TB in general. An estimated 2 billion people have latent TB.\nActive TB. This condition makes you sick and can spread to others. It can occur in the first few weeks after infection with the TB bacteria, or it might occur years later.\n\nSigns and symptoms of active TB include:\n\n - Coughing that lasts three or more weeks\n - Coughing up blood\n - Chest pain, or pain with breathing or coughing\n - Unintentional weight loss\n - Fatigue\n - Fever\n - Night sweats\n - Chills\n - Loss of appetite\n\nTuberculosis can also affect other parts of your body, including your kidneys, spine or brain. When TB occurs outside your lungs, signs and symptoms vary according to the organs involved. For example, tuberculosis of the spine may give you back pain, and tuberculosis in your kidneys might cause blood in your urine.", "Tuberculosis is caused by bacteria that spread from person to person through microscopic droplets released into the air. This can happen when someone with the untreated, active form of tuberculosis coughs, speaks, sneezes, spits, laughs or sings.\n\nAlthough tuberculosis is contagious, it's not easy to catch. You're much more likely to get tuberculosis from someone you live with or work with than from a stranger. Most people with active TB who've had appropriate drug treatment for at least two weeks are no longer contagious.")
    };

    public Disease(String name, String description, String symptoms, String causes) {
        this.name = name;
        this.description = description;
        this.symptoms = symptoms;
        this.causes = causes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getCauses() {
        return causes;
    }

    public void setCauses(String causes) {
        this.causes = causes;
    }
}
