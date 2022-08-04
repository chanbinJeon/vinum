/**
 * 
 */
package vinum.poll;

/**
 * @author user
 *
 */
public interface PollDAOIF {
	public long selectPoll(long pollindex);
	public int insertPoll(PollVO pollVO);
	public int updatePoll(PollVO pollVO);
	public int deletePoll(PollVO pollVO);
	public int insertPollquestion(PollquestionVO questionVO);
	public int updatePollquestion(PollquestionVO questionVO);
	public int deletePollquestion(PollquestionVO questionVO);
	public int insertPollquestionchoice(PollquestionselectVO choiceVO);
	public int updatePollquestionchoice(PollquestionselectVO choiceVO);
	public int deletePollquestionchoice(PollquestionselectVO choiceVO);
}
