package com.erep.elucs.extractor;

import com.erep.elucs.model.json.battle.Battle;

/**
 * @author dragos
 */
public interface BattleExtractor {
    public Battle getBattleInfo(String battleId);
}
