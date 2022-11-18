package com.demo.udemy.project.auth;

public class JwtConfig {
	public static final String LLAVE_SECRETA = "alguna.llave.secreta.123456789";
	
	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEpQIBAAKCAQEA0yS8X1/fteMbABkm1vAok0K1fgAtI8gWKTvTsr92OHa6Yqo8\r\n"
			+ "AUSt/XK1+GmkOFADr4fnbzEVS7jyrMCb/KsCJAylnSRC+WWOq12slEc2vLZpVSpD\r\n"
			+ "l/Kl/wmnLGxUFGUeL4j/7+eIN9gVXgepouR5l44oXWgFxe5oUS+FVS2Nlw9aIIpN\r\n"
			+ "r8Yv67qATRQzyo5zH+gt2uK/sI04BTbgUNJoyw1ABPle2dFiQ6XcN9xvdXcugoqD\r\n"
			+ "3rIXHWwsKFQyjvvNKNNdAsRTJaEHKDjVYDgGTDzNWqA+Zk6pUN67vU2Yx+VuJ5cP\r\n"
			+ "PwvK0wPEI96ZerXk86BuL0X3pio9mUoe1RH6SwIDAQABAoIBAAtqJgDl9vsnTvNf\r\n"
			+ "aLkf/KGRbqxkKAySKZiLEnPMZADDcmoZF+tdoiZciDfoxicBNGHN8BYTyjnwwrXS\r\n"
			+ "J9yuBgya3m0zY6eF9QOQqd7ORshG+ETRZxwU0yKJjA8bwCPmH46kUmnO049pUCZo\r\n"
			+ "NaSHw4cM+WOrVvyPWfZhokyrjMcIxUrlzihdHjUYUrLgEcSdJ5oKmRG8INCncx0R\r\n"
			+ "aJHPLJzsEIr8L917bdTrf0Nqu/p0JievJJFHJdnvDKgRnadt/frlkJGJ/8WSKsUa\r\n"
			+ "BKn0zrWcbIhmBfjfPLogW8B1kfBTtqxXutxRRCN26m2HNxQCAXniPqMCNp5bVhQT\r\n"
			+ "ZLzvo9ECgYEA7VGyx6Umbx+6GwZyUiUpfJXmnIN5DvKbZ5cnwPobdfE6wVIPROQP\r\n"
			+ "rIkzM0vK6I6hNddZv2LELMFxhYI/X6L6iL95lolnyZXfnh5ZnjafPsyPrRJI3/ga\r\n"
			+ "RKNzsPDiaGBaJmyRdspS72yFdkkdrOwsngNvNRAUm6DNjmF+lapblVkCgYEA48OQ\r\n"
			+ "Iaq4tk3zQpRASl3eDA6UdFfVBZXS5+Acu4njyeAPOleH/V7wXTDHL2UrE6QilxBm\r\n"
			+ "AFpsbMYhDE2fEWtYFpwbUC9UyJler2VKPgdQVN8wHUK8yc8n7A6q2i8YkptNyoIg\r\n"
			+ "v6/j0N7d1U0Dyduy3HEwGgio9/qG7Blp7rvYhEMCgYEAwd9jQQve6RsvK1LJ4+eu\r\n"
			+ "C7ReD/Cr3hU99ZObi2AHPQPT7wh9ptb1Iwt2g2pgmjmi41xJWjtybemeNuZfpV58\r\n"
			+ "c2iRCPS5kApbA05iAgk3cNMmcMomNKn3s6kgIyW2oHROUWOSNkw1EplCMo6qqpDK\r\n"
			+ "JlBB8kRvwW/NXYqyIcxpQwkCgYEAxm95wXtGFr7vM5CKOsBxVrvVJ0/mrkkMSSz+\r\n"
			+ "m33VUeq+GaxtNJhkfiyjPW29DA2yfT6yP5iIYnR0Eo4GCl0lj/1N5px2F5dX4SQ0\r\n"
			+ "fLpOiMMy3ito48JyG73jqNfjZsecDNU2xwrtRusFBnNk25dny5tptyTYYcSJjGXP\r\n"
			+ "30kVqJUCgYEAhmhaheSF7g3bixCG5c9VNneA4Z2jGa3Df94BYEisFWuBGQkjNVvG\r\n"
			+ "ygeKIs0eZ/lZwragXWOaecgs4hlSEeaFK+gHMfEuAZ6PDzHxFytFSHEG7EUUKYd0\r\n"
			+ "eQUadcI6Nyf6q5cXSzUtsKJV7FO/4FFcHhKp94Ee5+SoKokjLgmCkGc=\r\n"
			+ "-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0yS8X1/fteMbABkm1vAo\r\n"
			+ "k0K1fgAtI8gWKTvTsr92OHa6Yqo8AUSt/XK1+GmkOFADr4fnbzEVS7jyrMCb/KsC\r\n"
			+ "JAylnSRC+WWOq12slEc2vLZpVSpDl/Kl/wmnLGxUFGUeL4j/7+eIN9gVXgepouR5\r\n"
			+ "l44oXWgFxe5oUS+FVS2Nlw9aIIpNr8Yv67qATRQzyo5zH+gt2uK/sI04BTbgUNJo\r\n"
			+ "yw1ABPle2dFiQ6XcN9xvdXcugoqD3rIXHWwsKFQyjvvNKNNdAsRTJaEHKDjVYDgG\r\n"
			+ "TDzNWqA+Zk6pUN67vU2Yx+VuJ5cPPwvK0wPEI96ZerXk86BuL0X3pio9mUoe1RH6\r\n"
			+ "SwIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";
}
