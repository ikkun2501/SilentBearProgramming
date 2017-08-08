package com.bunji;

import java.io.IOException;

import org.riversun.slacklet.Slacklet;
import org.riversun.slacklet.SlackletRequest;
import org.riversun.slacklet.SlackletResponse;
import org.riversun.slacklet.SlackletService;
import org.riversun.xternal.simpleslackapi.SlackChannel;

public class Example00 {

	public static void main(String[] args) throws IOException {

		// String botToken =
		// ResourceBundle.getBundle("credentials").getString("slack.bot_api_token");
		String botToken = "";

		SlackletService slackService = new SlackletService(botToken);

		slackService.addSlacklet(new Slacklet() {

			@Override
			public void onMessagePosted(SlackletRequest req, SlackletResponse resp) {
				// メッセージがユーザーからポストされた

				// メッセージがポストされたチャンネルを取得する
				SlackChannel channel = req.getChannel();

				if ("bear-programming".equals(channel.getName())) {

					// メッセージ本文を取得
					String content = req.getContent();
					if (content.contains("相談")) {
						resp.reply("ぼっとじゃなく同僚に相談したら？");
					} else if (content.contains("解決")) {
						resp.reply("俺の手柄だね");
					} else if (content.contains("?")) {
						resp.reply("相談する前に自分で調べなよ");
					} else if (content.contains("くまさん")) {
						resp.reply("呼んだ？");
					} else {
						resp.reply("そうなんだ。");
					}

					// メッセージがポストされたチャンネルに対して、BOTからメッセージを送る

				}

				if ("general".equals(channel.getName())) {

					// メッセージ本文を取得
					String content = req.getContent();

					if (content.contains("くまさん")) {
						resp.reply("呼んだ？");
					}

					// メッセージがポストされたチャンネルに対して、BOTからメッセージを送る

				}
			}
		});

		// slackletserviceを開始(slackに接続)
		slackService.start();

	}

}
