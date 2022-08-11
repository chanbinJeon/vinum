/**
 * 
 */
package vinum.poll;

/**
 * @author user
 *
 */
public interface PollDAOIF {
	public void listPolls();
	public long selectPoll(long pollindex);
	public int insertPoll(String polltitle, long pollauthor);
	public int updatePoll(String polltitle, long pollauthor);
	public int deletePoll(String polltitle, long pollauthor);
	public void listPollquestions();
	public int insertPollquestion(PollquestionVO questionVO);
	public int updatePollquestion(PollquestionVO questionVO);
	public int deletePollquestion(PollquestionVO questionVO);
	public void listPollquestionchoices();
	public int insertPollquestionchoice(PollquestionselectVO choiceVO);
	public int updatePollquestionchoice(PollquestionselectVO choiceVO);
	public int deletePollquestionchoice(PollquestionselectVO choiceVO);
}
