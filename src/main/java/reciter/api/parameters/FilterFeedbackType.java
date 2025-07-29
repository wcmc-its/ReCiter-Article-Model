package reciter.api.parameters;

/**
 * @author szd2013
 * @see <a href="https://github.com/wcmc-its/ReCiter/issues/287">Filter Feedback</a>
* Enum representing different types of filter feedback.
* <p>
* This enum is used to specify the type of feedback to filter:
* <ul>
*   <li>{@link #ALL} - Includes all feedback types.</li>
*   <li>{@link #ACCEPTED_ONLY} - Includes only accepted feedback.</li>
*   <li>{@link #REJECTED_ONLY} - Includes only rejected feedback.</li>
*   <li>{@link #ACCEPTED_AND_NULL} - Includes accepted and null feedback.</li>
*   <li>{@link #ACCEPTED_AND_REJECTED} - Includes both accepted and rejected feedback.</li>
*   <li>{@link #REJECTED_AND_NULL} - Includes rejected and null feedback.</li>
*   <li>{@link #NULL} - Includes only null feedback.</li>
* </ul>
*/
public enum FilterFeedbackType {
   
   /** Includes all feedback types. */
   ALL,

   /** Includes only accepted feedback. */
   ACCEPTED_ONLY,

   /** Includes only rejected feedback. */
   REJECTED_ONLY,

   /** Includes accepted and null feedback. */
   ACCEPTED_AND_NULL,

   /** Includes both accepted and rejected feedback. */
   ACCEPTED_AND_REJECTED,

   /** Includes rejected and null feedback. */
   REJECTED_AND_NULL,

   /** Includes only null feedback. */
   NULL
}
