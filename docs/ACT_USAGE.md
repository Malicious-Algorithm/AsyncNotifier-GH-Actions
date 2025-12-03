# Running GitHub Actions Locally with `act`

This project uses [act](https://github.com/nektos/act) to run GitHub Actions workflows locally. This allows you to test your CI/CD pipeline without pushing to the remote repository.

## Prerequisites

1.  **Docker**: Ensure Docker is installed and running on your machine.
2.  **act**: Ensure `act` is installed.
    *   **macOS**: `brew install act`
    *   **Linux**: `curl https://raw.githubusercontent.com/nektos/act/master/install.sh | sudo bash` (or via your package manager)
    *   **Windows**: `choco install act-cli`

## Usage

We have provided a convenience script to run the pipeline simulating a push to the `main` branch.

### Run the script

```bash
./run_local_pipeline.sh
```

### Run manually

You can also run `act` directly:

```bash
# Run the default event (push)
act

# Run a specific event
act pull_request

# Run a specific job
act -j build
```

## Troubleshooting

-   **Docker Socket**: If you encounter errors related to the Docker socket, ensure your user has permission to access `/var/run/docker.sock` or that Docker Desktop is running.
-   **Secrets**: If your workflow uses secrets, you may need to provide them to `act` using the `-s` flag or a secrets file. (e.g., `act -s MY_SECRET=value`).
