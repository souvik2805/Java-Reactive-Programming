package reactivefromudemy.sec11_sinks;

import reactivefromudemy.courseUtil.Util;
import reactivefromudemy.sec11_sinks.assignment.SlackMember;
import reactivefromudemy.sec11_sinks.assignment.SlackRoom;

public class Lec07SlackRoomAssignment {

	public static void main(String[] args) {
		SlackRoom slackRoom = new SlackRoom("Reactor");

		SlackMember sam = new SlackMember("sam");
		SlackMember jake = new SlackMember("jake");
		SlackMember mike = new SlackMember("mike");

		slackRoom.joinRoom(sam);
		slackRoom.joinRoom(jake);

		sam.says("Hi all ...");
		Util.sleepSeconds(4);

		jake.says("Hey ! ");
		jake.says("I am jake");
		Util.sleepSeconds(4);

		slackRoom.joinRoom(mike);
		mike.says("I am Mike, Thank You");

	}
}
