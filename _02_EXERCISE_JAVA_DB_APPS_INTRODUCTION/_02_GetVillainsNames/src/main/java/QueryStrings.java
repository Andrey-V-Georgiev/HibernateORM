class QueryStrings {

    static String villainsHavingOver15Minions(){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT v.name, COUNT(mv.minion_id) AS `count` ");
        sb.append("FROM villains AS v ");
        sb.append("JOIN minions_villains mv on v.id = mv.villain_id ");
        sb.append("GROUP BY v.name ");
        sb.append("HAVING `count` > ? " );
        sb.append("ORDER BY `count` DESC");
        return sb.toString();
    }

}
