package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.features.CommandsFeature;
import edu.kis.powp.jobs2d.features.MacroFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectRunMacroListener implements ActionListener {
    private DriverManager driverManager;

    public SelectRunMacroListener(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CommandsFeature.getDriverCommandManager().setCurrentCommand(MacroFeature.getMacroDriver().getDriverCommandList(), "Macro");
        MacroFeature.getMacroDriver().setDriverFeatureCurrentDriver();
        DriverCommand driverCommand = CommandsFeature.getDriverCommandManager().getCurrentCommand();
        driverCommand.execute(driverManager.getCurrentDriver());
        MacroFeature.getMacroDriver().clearCommandSet();
    }
}
