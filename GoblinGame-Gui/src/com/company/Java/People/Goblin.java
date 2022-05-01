package com.company.Java.People;

import com.company.Java.Land.Location;

public class Goblin extends Humanoid {
    int threat;
    int type = 2;

    public Goblin(int threat){
        ThreatSet(threat);
    }

    public Goblin(int threat, Location location){
        ThreatSet(threat);
        setLocation(location);
    }

    public void ThreatSet(int threat){
        setThreat(threat);
        setSymbol('G');

        setDescription("A goblin of threat "+ threat);
        switch (threat){
            case 3:
                setHealth(4);
                setSight(2);
                setMovement(2);
                setStrength(3);
                break;
            case 2:
                setHealth(3);
                setSight(3);
                setMovement(3);
                setStrength(2);
                break;
            case 1:
                setHealth(2);
                setSight(2);
                setMovement(2);
                setStrength(2);
                break;
            default:
                setHealth(1);
                setStrength(1);
                setMovement(1);
                setSight(1);
                break;

        }
    }

    @Override
    public String toString(){
        return "Goblin threat: "+ threat +"Health: "+ health+
                "Strength: " +strength+
                "Movement: " + movement+
                "Sight: " + sight;
    }

    public int getThreat() {
        return threat;
    }

    public void setThreat(int threat) {
        this.threat = threat;
    }
}
